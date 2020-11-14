package com.example.demo.util;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2020-11-14
 */
public class AppConstants {

    private AppConstants() {
    }

    public static final class Detail {
        private Detail() {
        }

        public static final char PRODUCT_ACTIVE = 'A';
        public static final char PRODUCT_DELETED = 'D';
    }

    public static final class NotFound {
        private NotFound() {
        }

        public static final String NO_PRODUCT_FOUND = "No product found for id: ";
        public static final String NO_PRODUCT_CATEGORY_FOUND = "No product category found for id: ";
    }

    public static final class AlreadyExists {
        private AlreadyExists() {
        }

        public static final String PRODUCT_NAME = "Product name already exists!";
    }

    public static final class NotPresented {
        private NotPresented() {
        }

        public static final String PRODUCT_NAME = "Product name is required!";
        public static final String PRODUCT_CATEGORY = "Product category is required!";
    }

    public static final class Created {
        private Created() {
        }

        public static final String PRODUCT_CREATED = "Product is created";
        public static final String PRODUCT_DELETED = "Product is deleted";
    }
}
