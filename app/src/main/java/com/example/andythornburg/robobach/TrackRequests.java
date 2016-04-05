package com.example.andythornburg.robobach;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

/**
 * Created by andythornburg on 4/5/16.
 */
public class TrackRequests {
    super(builder);
}

    public SettableFuture<List<Track>> getAsync() {
        SettableFuture<List<Track>> tracksFuture = SettableFuture.create();

        try {
            final String jsonString = getJson();
            final JSONObject jsonObject = JSONObject.fromObject(jsonString);

            tracksFuture.set(JsonUtil.createTracks(jsonObject));
        } catch (Exception e) {
            tracksFuture.setException(e);
        }

        return tracksFuture;
    }

    public List<Track> get() throws IOException, WebApiException {
        final String jsonString = getJson();
        final JSONObject jsonObject = JSONObject.fromObject(jsonString);

        return JsonUtil.createTracks(jsonObject);
    }

    public static Builder builder() {
        return new Builder();
    }

public static final class Builder extends AbstractRequest.Builder<Builder> {

    public Builder id(List<String> ids) {
        assert (ids != null);
        String idsParameter = Joiner.on(",").join(ids).toString();
        path("/v1/tracks");
        return parameter("ids", idsParameter);
    }

    public TracksRequest build() {
        return new TracksRequest(this);
    }

}

