package com.blog.awsblogupload.bucket;

public enum BucketName {

    PROFILE_IMAGE("blog-project-bucket-543");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
