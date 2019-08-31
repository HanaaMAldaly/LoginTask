package com.hanaa.logintask.data.repository;

import com.hanaa.logintask.data.exception.LoginFailedException;
import com.hanaa.logintask.data.exception.StatusCodes;
import com.hanaa.logintask.data.model.LoginResponseCloud;
import com.hanaa.logintask.data.network.LoginCloudManagement;
import com.hanaa.logintask.domain.repository.LoginRepository;

import io.reactivex.Observable;

public class LoginRepositoryImpl implements LoginRepository {
    private LoginRepositoryImpl() {
    }


    private static class RepositoryInstance {
       private static LoginRepository INSTANCE = new LoginRepositoryImpl();
    }
    public static LoginRepository getInstance(){
        return RepositoryInstance.INSTANCE;
    }

    @Override
    public Observable<LoginResponseCloud> login(String email, String password) {
        Observable<LoginResponseCloud> data= LoginCloudManagement.getInstance().login(email,password);
        if(data.blockingSingle().getStatus()!= StatusCodes.LOGIN_SUCESS.getStatus()){
            return Observable.error(new LoginFailedException(data.blockingFirst()));
        }
        return data;
    }

}
