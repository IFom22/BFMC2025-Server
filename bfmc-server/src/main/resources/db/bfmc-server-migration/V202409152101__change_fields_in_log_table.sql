ALTER TABLE server.log
    RENAME COLUMN class_сreator TO created_in_class;

ALTER TABLE server.log
    RENAME COLUMN function_сreator TO created_in_function;