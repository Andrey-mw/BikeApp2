package com.example.android.bikeapp.content_provider;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Android on 12.11.2015.
 */
public final class BikeContract {
    private BikeContract() {
    }

    public static final String AUTHORITY = "com.example.android.bikeapp.content_provider.BikeContentProvider";

    public static final class Users implements BaseColumns {
        private Users() {
        }

        private static final String SCHEME = "content://";
        private static final String PATH_USERS = "/users";
        private static final String PATH_USERS_ID = "/users/";

        public static final Uri CONTENT_URI = Uri.parse(SCHEME + AUTHORITY + PATH_USERS);
        public static final Uri CONTENT_ID_URI_BASE = Uri.parse(SCHEME + AUTHORITY + PATH_USERS_ID);

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE;

        public static final String DEFAULT_SORT_ORDER = "first_name ASC";


        public static final String FIRST_NAME = "first_name";
        public static final String SECOND_NAME = "second_name";
        public static final String AGE = "age";
        public static final String MODEL_BIKE = "model_bike";

        public static final String[] DEFAULT_PROJECTION = new String[]{
                BikeContract.Users._ID,
                BikeContract.Users.FIRST_NAME,
                BikeContract.Users.SECOND_NAME,
                BikeContract.Users.AGE,
                BikeContract.Users.MODEL_BIKE
        };
    }
}
