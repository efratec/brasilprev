package com.brasilprev.api.constants;

public interface Constants {

    interface Messages {
        String CUSTOMER_SAVED_SUCESSFULLY = "Cliente salvo com sucesso!";
        String CUSTOMER_UPDATED_SUCESSFULLY = "Cliente atualizado com sucesso!";
        String CUSTOMER_IS_ALREADY_REGISTERED = "Cliente já está cadastrado!";
        String CUSTOMER_DELETED_SUCCESSFULLY = "Cliente deletado com sucesso!";
        String CPF_IS_A_REQUIRED_FIELD = "CPF é um campo obrigatório!";
        String NAME_IS_A_REQUIRED_FIELD = "Nome é um campo obrigatório";
    }

    interface Status {
        String STATUS_200_GET_OK = "Successfully retrieved";
        String STATUS_200_POST_OK = "Successfully posted";
        String STATUS_201_CREATED = "Successfully created";
        String STATUS_204_NO_CONTENT = "No Content";
        String STATUS_400_BAD_REQUEST = "Resource is invalid";
        String STATUS_404_NOT_FOUND = "Resource not found";
        String STATUS_409_CONFLICT = "Business conflict";
        String STATUS_500_INTERNAL_SERVER_ERROR = "The application has encountered an unknown error. Please try again.";

    }

}
