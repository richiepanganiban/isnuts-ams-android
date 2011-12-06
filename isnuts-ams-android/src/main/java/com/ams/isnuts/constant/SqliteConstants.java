package com.ams.isnuts.constant;

public class SqliteConstants {

	public static final String CREATE_TABLE_CATEGORIES = "CREATE TABLE categories ("
			+ "category_id INTEGER PRIMARY KEY, " + "name TEXT)";

	public static final String CREATE_TABLE_SERVICE_APPLICATIONS = "CREATE TABLE service_applications("
			+ "service_application_id INTEGER PRIMARY KEY,"
			+ "title TEXT, "
			+ "description TEXT, "
			+ "service_type TEXT, "
			+ "service_number TEXT, "
			+ "active_promo INTEGER, "
			+ "append_mobile_to_service_number INTEGER)";

	public static final String CREATE_TABLE_KEYWORDS = "CREATE TABLE keywords ("
			+ "item_type TEXT, "
			+ "literal_value TEXT, "
			+ "service_application_reference_id INTEGER service_application_reference_id "
			+ "REFERENCES service_applications(service_application_id) ON DELETE CASCADE)";

	public static final String CREATE_TABLE_CUSTOM_SERVICE_APPLICATION = "CREATE TABLE custom_service_applications("
		+ "custom_service_application_id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "custom_service_name TEXT,"
		+ "service_application_reference_id INTEGER service_application_reference_id "
		+ "REFERENCES service_applications(service_application_id) ON DELETE CASCADE)";

	public static final String CREATE_TABLE_CUSTOM_KEYWORDS = "CREATE TABLE custom_keywords("
			+ "item_type TEXT," 
			+ "literal_value TEXT," 
			+ "custom_service_application_reference_id INTEGER custom_service_application_reference_id " 
			+ "REFERENCES custom_service_applications(custom_service_application_id) ON DELETE CASCADE)";

	public static final String CREATE_TABLE_SERVICE_CATEGORIES_LOOKUP = "CREATE TABLE service_categories_lookup ("
			+ "service_application_reference_id INTEGER service_application_reference_id REFERENCES service_applications(service_application_id) ON DELETE CASCADE,"
			+ "category_reference_id INTEGER category_reference_id REFERENCES categories(category_id) ON DELETE CASCADE)";

	public static final String CREATE_TRIGGER_CUSTOM_SERVICE_APPLICATION = "CREATE TRIGGER fk_insert_custom_service " +
			"BEFORE INSERT ON custom_service_applications " +
			"FOR EACH ROW BEGIN " +
			"SELECT RAISE(ROLLBACK, 'Foreign key constraint violation') " +
			"WHERE (SELECT service_application_id FROM service_applications WHERE service_application_id=NEW.service_application_reference_id) IS NULL;END;";
	
	public static final String CREATE_TRIGGER_SERVICE_APPLICATION = "CREATE TRIGGER fk_delete_service_applications "
			+ "BEFORE DELETE on service_applications "
			+ "FOR EACH ROW BEGIN "
			+ "SELECT RAISE(ROLLBACK, 'Foreign key constraint violation') "
			+ "WHERE (select service_application_reference_id FROM service_categories_lookup WHERE category_reference_id=old.service_application_id) IS NOT NULL;END;";

	public static final String CREATE_TRIGGER_CATEGORY = "CREATE TRIGGER fk_delete_category "
			+ "BEFORE DELETE on categories "
			+ "FOR EACH ROW BEGIN "
			+ "SELECT RAISE(ROLLBACK, 'Foreign key constraint violation') "
			+ "WHERE (select category_reference_id FROM service_categories_lookup WHERE category_reference_id=old.category_id) IS NOT NULL;END;";
	
	public static final String CREATE_TRIGGER_SERVICE_CATEGORY = "CREATE TRIGGER fk_insert_service_categories_lookup " 
			+ "BEFORE INSERT ON service_categories_lookup " 
			+ "FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'Foreign key constraint violation') " 
			+ "WHERE (SELECT service_application_id FROM service_applications WHERE service_application_id=NEW.service_application_reference_id) IS NULL OR (SELECT category_id FROM categories WHERE category_id=NEW.category_reference_id) IS NULL;END;";

}
