.PHONY: verify
verify:
	mvn com.spotify.fmt:fmt-maven-plugin:format verify

.PHONY: format
format:
	mvn com.spotify.fmt:fmt-maven-plugin:format
