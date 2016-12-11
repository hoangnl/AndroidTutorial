package com.hoang.top10downloaded;

/**
 * Created by HOANG on 10-Dec-16.
 */

public class FeedEntry {

    private String name;
    private String artist;
    private String releaseDate;
    private String summary;
    private String imgageUrl;

    public String getImgageUrl() {
        return imgageUrl;
    }

    public void setImgageUrl(String imgageUrl) {
        this.imgageUrl = imgageUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

//    @Override
//    public String toString() {
//        return "name=" + name + '\n' +
//                ", artist=" + artist + '\n' +
//                ", releaseDate=" + releaseDate + '\n' +
//                ", imageURL=" + imgageUrl + '\n';
//    }
}
