package com.example.eliaacompany.service;

import com.example.eliaacompany.model.login.LoginRequest;
import com.example.eliaacompany.model.login.ExampleLogin;
import com.example.eliaacompany.model.reservation.ReservationData;
import com.example.eliaacompany.model.reservation.ReservationExample;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Service {

    //login
    @POST("login")
    Call<ExampleLogin> login(@Body LoginRequest loginRequest);

    @GET("reservation")
    Call<List<ReservationData>> getReservationData(@Header("Authorization") String token);

    @GET("reservation/{id}")
    Call<List<ReservationExample>> getReservationDataDetails(@Part("id") int id, @Header("Authorization") String token);


    class ApiClient {
        private static final String BASE_URL = "http://127.0.0.1:8000/api/";

        public static Service getRetrofitInstance() {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .writeTimeout(10000, TimeUnit.SECONDS)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest = chain.request().newBuilder()
                                    .addHeader("Accept", "application/json")
                                    .addHeader("Content-Type", "multipart/form-data")
                                    .addHeader("X-Requested-With", "XMLHttpRequest")
                                    // .addHeader("Authorization", "Bearer" + Token)
                                    .addHeader("Accept-Language", "en")

                                    .build();
                            return chain.proceed(newRequest);
                        }
                    })

                    .readTimeout(10000, TimeUnit.SECONDS).addInterceptor(interceptor).addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest = chain.request().newBuilder()
                                    .addHeader("Accept", "application/json")
                                    .addHeader("Content-Type", "multipart/form-data")
                                    .addHeader("X-Requested-With", "XMLHttpRequest")
                                    // .addHeader("Authorization", "Bearer" + Token)
                                    .addHeader("Accept-Language", "en")

                                    .build();
                            return chain.proceed(newRequest);
                        }
                    })
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();


            return retrofit.create(Service.class);
        }
    }

}

