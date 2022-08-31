package com.blog.awsblogupload.datastore;

import com.blog.awsblogupload.profile.UserProfile;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileData {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("efc1879d-8458-4000-8a8e-a095f8847e11"), "janetjones", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("4c9ce5a2-598d-46f8-a022-682bca848e8e"), "antoniojunior", null));
    }
    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }

}
