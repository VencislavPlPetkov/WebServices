package org.venci.webservices.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.venci.webservices.messenger.database.DatabaseMockClass;
import org.venci.webservices.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseMockClass.getProfiles();

	public ProfileService() {

		profiles.put("venci", new Profile(1L, "venci", "Venci", "Vencislavov"));

	}

	public List<Profile> getAllProfiles() {

		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {

		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {

		profile.setId(profiles.size() + 1);

		profiles.put(profile.getProfileName(), profile);

		return profile;

	}

	public Profile updateProfile(Profile profile) {

		if (profile.getProfileName().isEmpty()) {
			return null;
		}

		profiles.put(profile.getProfileName(), profile);

		return profile;

	}

	public Profile removeProfile(String profileName) {

		return profiles.remove(profiles.get(profileName));

	}

}
