//
// Getdown - application installer, patcher and launcher
// Copyright (C) 2004-2013 Three Rings Design, Inc.
// http://code.google.com/p/getdown/source/browse/LICENSE

package com.threerings.getdown.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

public class ConnectionUtil
{
    /**
     * Opens a connection to a URL, setting the authentication header if user info is present.
     */
    public static URLConnection open (URL url)
        throws IOException
    {
        URLConnection conn = url.openConnection();

        // If URL has a username:password@ before hostname, use HTTP basic auth
        String userInfo = url.getUserInfo();
        if (userInfo != null) {
            // Remove any percent-encoding in the username/password
            userInfo = URLDecoder.decode(userInfo, "UTF-8");
            // Now base64 encode the auth info and make it a single line

            String encoded = new String(java.util.Base64.getEncoder().encode(userInfo.getBytes("UTF-8"))).
                replaceAll("\\n","").replaceAll("\\r", "");
            conn.setRequestProperty("Authorization", "Basic " + encoded);
        }

        return conn;
    }

    /**
     * Opens a connection to a http or https URL, setting the authentication header if user info
     * is present. Throws a class cast exception if the connection returned is not the right type.
     */
    public static HttpURLConnection openHttp (URL url)
        throws IOException
    {
        return (HttpURLConnection)open(url);
    }
}
