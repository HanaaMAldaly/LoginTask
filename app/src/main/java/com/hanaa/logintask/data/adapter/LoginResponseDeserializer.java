package com.hanaa.logintask.data.adapter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.hanaa.logintask.data.model.DataCloud;
import com.hanaa.logintask.data.model.LoginResponseCloud;
import com.hanaa.logintask.data.model.UserCloud;

import java.lang.reflect.Type;

public class LoginResponseDeserializer implements JsonDeserializer<LoginResponseCloud> {
    @Override
    public LoginResponseCloud deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        LoginResponseCloud item = new LoginResponseCloud();
        DataCloud dataCloud = new DataCloud();

        final JsonObject jsonObject = json.getAsJsonObject();
        final int status = jsonObject.get("status").getAsInt();
        final String message = jsonObject.get("message").getAsString();
        if (jsonObject.get("data") instanceof JsonArray) {
            JsonArray itemsJsonArray = jsonObject.get("data").getAsJsonArray();

            for (JsonElement itemsJsonElement : itemsJsonArray) {
                final JsonObject itemJsonObject = itemsJsonElement.getAsJsonObject();
                final UserCloud user = new Gson().fromJson(itemJsonObject.get("user").getAsJsonObject(), UserCloud.class);

                dataCloud.setUser(user);
            }
        } else if ((jsonObject.get("data")) instanceof JsonObject) {
            dataCloud = new Gson().fromJson(jsonObject.get("data").getAsJsonObject(), DataCloud.class);
        }
        item.setData(dataCloud);
        item.setMessage(message);
        item.setStatus(status);

        return item;
    }
}