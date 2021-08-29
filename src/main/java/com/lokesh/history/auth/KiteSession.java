package com.lokesh.history.auth;

import com.lokesh.history.config.Config;
import com.lokesh.history.Temp;
import com.zerodhatech.kiteconnect.KiteConnect;
import com.zerodhatech.kiteconnect.kitehttp.exceptions.KiteException;
import com.zerodhatech.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Component
@RestController
@RequiredArgsConstructor
public class KiteSession {

    Config config;

    @RequestMapping(path = "/kiteconnect", method = RequestMethod.POST)
    public KiteConnect initKiteConnectSession(@RequestParam("request_token") String request_token) {
        if (StringUtils.hasLength(request_token)) {
            return createKiteConnectSession(request_token);
        }
        return null;
    }

    public KiteConnect createKiteConnectSession(String request_token) {
        // Initialize Kiteconnect using apiKey.
        KiteConnect kiteSdk = new KiteConnect(config.getApiKey());
        //TODO:Need to remove the static and store kiteSdk as an session object or store tokens in user session session
        Temp.kitesdk =  new KiteConnect(config.getApiKey());
        // Set userId.
        Temp.kitesdk.setUserId(config.getUserId());
        // Get accessToken as follows,
        User kiteUser;
        try {
            kiteUser = Temp.kitesdk.generateSession(request_token, config.getClientSecret());
            // Set request token and public token which are obtained from login process.
            Temp.kitesdk.setAccessToken(kiteUser.accessToken);
            Temp.kitesdk.setPublicToken(kiteUser.publicToken);
            //TODO: Fetch the spring session of the user and store the KiteUser object as part of the session.

            return kiteSdk;
        } catch (KiteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return kiteSdk;
    }
}
