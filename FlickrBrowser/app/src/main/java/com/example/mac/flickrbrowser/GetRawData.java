package com.example.mac.flickrbrowser;

import android.os.AsyncTask;
import android.util.Log;
import android.util.StringBuilderPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

enum DownloadStatus {IDLE, PROCESSING, NOT_INTIALISED, FAILED_OR_EMPTY, OK}

/**
 * Created by mac on 1/15/17.
 */

class GetRawData extends AsyncTask<String, Void, String> {
    private static final String TAG = "GetRawData";

    private final OnDownloadComplete mCallback;
    private DownloadStatus mDownloadStatus;

    interface OnDownloadComplete {
        void onDownloadComplete(String data, DownloadStatus status);
    }

    public GetRawData(OnDownloadComplete callback) {
        this.mDownloadStatus = DownloadStatus.IDLE;
        this.mCallback = callback;

    }


    @Override
    protected void onPostExecute(String s) {
        Log.d(TAG, "onPostExecute: parameter = " + s);
        if (mCallback != null) {
            mCallback.onDownloadComplete(s, mDownloadStatus);
        }
        Log.d(TAG, "onPostExecute: ends");
    }

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        if (strings == null) {
            mDownloadStatus = DownloadStatus.NOT_INTIALISED;
        }

        try {
            mDownloadStatus = DownloadStatus.PROCESSING;
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int response = connection.getResponseCode();
            Log.d(TAG, "doInBackground: The response code is " + response);

            StringBuilder result = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while (null != (line = reader.readLine())) {
                result.append(line).append("\n");

            }
            mDownloadStatus = DownloadStatus.OK;
            return result.toString();
        } catch (MalformedURLException e) {
            Log.d(TAG, "doInBackground: Invalid url: " + e.getMessage());
        } catch (IOException e) {
            Log.d(TAG, "doInBackground: IO Exception " + e.getMessage());

        } catch (SecurityException e) {
            Log.d(TAG, "doInBackground: security permssion. Need permission" + e.getMessage());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.d(TAG, "doInBackground: Error closing stream " + e.getMessage());
                }
            }

        }
        mDownloadStatus = DownloadStatus.FAILED_OR_EMPTY;
        return null;
    }
}

