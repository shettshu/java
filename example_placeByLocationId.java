/**
 *
 * Script-Name: example_placeByLocationId
 */

import com.mastercard.api.core.ApiConfig;
import com.mastercard.api.core.exception.*;
import com.mastercard.api.core.model.*;
import com.mastercard.api.core.model.map.*;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;
import java.io.*;
import java.util.Map;

import com.mastercard.api.places.*;

public class example_placeByLocationId {

	public static void main(String[] args) throws Exception {

		String consumerKey = "bIGzVSuozMfXKAx6BeKMA_GNWTmC19yUNmFndfnKff8d71cf!576a49c13a4749f2bf76cc544ebc68960000000000000000";   // You should copy this from "My Keys" on your project page e.g. UTfbhDCSeNYvJpLL5l028sWL9it739PYh6LU5lZja15xcRpY!fd209e6c579dc9d7be52da93d35ae6b6c167c174690b72fa
		String keyAlias = "cibc1";   // For production: change this to the key alias you chose when you created your production key
		String keyPassword = "cibcT2020";   // For production: change this to the key alias you chose when you created your production key
		InputStream is = new FileInputStream("C:/T2020/places/cibc1-production.p12"); // e.g. /Users/yourname/project/sandbox.p12 | C:\Users\yourname\project\sandbox.p12
		ApiConfig.setAuthentication(new OAuthAuthentication(consumerKey, is, keyAlias, keyPassword));   // You only need to set this once
		ApiConfig.setDebug(true);   // Enable http wire logging
		ApiConfig.setSandbox(false); // For production: use ApiConfig.setSandbox(false);
		//ApiConfig.setEnvironment(Environment.SANDBOX);

		try {
			RequestMap map = new RequestMap();
			map.set("locationId", "405901665");

			PlaceByLocationId response = PlaceByLocationId.query(map);
			out(response, "place.merchantName"); //-->FAMOUSFOOTWEAR#1749
			out(response, "place.streetAddr"); //-->2254 HWY K
			out(response, "place.cityName"); //-->O FALLON
			out(response, "place.stateProvidenceCode"); //-->MO
			out(response, "place.postalCode"); //-->63368
			out(response, "place.countryCode"); //-->USA
			out(response, "place.telephoneNumber"); //-->
			out(response, "place.mccCode"); //-->5661
			out(response, "place.legalCorporateName"); //-->BROWN SHOE COMPANY INC
			out(response, "place.industry"); //-->SHS
			out(response, "place.superIndustry"); //-->AAP
			out(response, "place.dateEstablished"); //-->10/23/1999
			out(response, "place.newBusinessFlag"); //-->FALSE
			out(response, "place.inBusiness7DayFlag"); //-->TRUE
			out(response, "place.inBusiness30DayFlag"); //-->TRUE
			out(response, "place.inBusiness60DayFlag"); //-->TRUE
			out(response, "place.inBusiness90DayFlag"); //-->TRUE
			out(response, "place.inBusiness180DayFlag"); //-->TRUE
			out(response, "place.inBusiness360DayFlag"); //-->TRUE
			out(response, "place.latitude"); //-->38.778083
			out(response, "place.longitude"); //-->-90.699706
			out(response, "place.geocodeQualityIndicator"); //-->STOREFRONT
			out(response, "place.primaryChannelOfDistribution"); //-->B
			out(response, "place.cashBack"); //-->FALSE
			out(response, "place.payAtThePump"); //-->FALSE
			out(response, "place.nfcFlag"); //-->TRUE
			out(response, "place.aggregateMerchantId"); //-->12077
			out(response, "place.aggregateMerchantName"); //-->FAMOUS FOOTWEAR
			out(response, "place.keyAggregateMerchantId"); //-->12077
			out(response, "place.parentAggregateMerchantId"); //-->10000344
			out(response, "place.parentAggregateMerchantName"); //-->CALERES / BROWN SHOE COMPANY INC
			out(response, "place.msaCode"); //-->7040
			out(response, "place.naicsCode"); //-->448210
			out(response, "place.dmaCode"); //-->609
			out(response, "place.locationId"); //-->300945305

		} catch (ApiException e) {
			err("HttpStatus: "+e.getHttpStatus());
			err("Message: "+e.getMessage());
			err("ReasonCode: "+e.getReasonCode());
			err("Source: "+e.getSource());
		}
	}

	public static void out(SmartMap response, String key) {
		System.out.println(key+"-->"+response.get(key));
	}

	public static void out(Map<String,Object> map, String key) {
		System.out.println(key+"--->"+map.get(key));
	}

	public static void err(String message) {
		System.err.println(message);
	}
}