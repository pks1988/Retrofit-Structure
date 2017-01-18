package util;

/**
 * Created by prasharma on 12/24/2016.
 */

public class Constants {

    public static enum API_TYPE {
        MOVIE_DETAILS("movie_details");

        private String url;

        API_TYPE(String url) {
            this.url = url;
        }

        public String url() {
            return url;
        }
    }
}
