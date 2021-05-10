<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/padding.css">
        <link rel="stylesheet" href="css/margin.css">
        <link rel="stylesheet" href="css/outline-hover.css">
        <title>Modifier un étudiant</title>
    </head>
    <body>
    <script>
    document.addEventListener('DOMContentLoaded', () => {
       var students = ${students_json};

        function getUserByEmail(mail) {
          return students.filter(
              function(students){ return students.mailAddress == mail }
          );
        }

        document.querySelector('#student_select').addEventListener("change", function() {
            document.querySelector(".success").innerText ="";

            let user = getUserByEmail(this.value)

            $('input[name="Surname"]').val(user[0].lastname);
            $('input[name="Name"]').val(user[0].firstname);
            $('input[name="Email"]').val(user[0].mailAddress);
            $('input[name="BDate"]').val(user[0].dateOfBirth);
            $('input[name="address"]').val(user[0].address);
            $('input[name="tel"]').val(user[0].phoneNumber);
        });

        $('#userDel').submit(function() {
            $('input[name="email"]').val($('input[name="Email"]').val());
            return true;
        });
    });
    </script
        <div class="form-row">
            <div class="form-group col-md-12">
                <div class="container conform">
                    <div class="cst-form">
                        <div class="row">
                            <h1 class="form-title">Modifier un étudiant</h1>
                        </div>
                        <form class="container-fluid" action="/etablissement/students_update" id="userform">
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="student_select" form="userform" >Choisir un étudiant</label>
                                    <select class="form-control" name="students" id="student_select">
                                        <option value="">--Sélectionner un étudiant--</option>
                                        <c:forEach items="${students}" var="student">
                                            <option value="${student.getMailAddress()}"><c:out value="${student.getLastname()}"/> <c:out value="${student.getFirstname()}"/></option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Nom</label>
                                    <input name="Surname" class="form-control" type="text" placeholder="Nom">
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Prenom</label>
                                    <input name="Name" class="form-control" type="text" placeholder="Prenom">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Email</label>
                                    <input name="Email" class="form-control" type="email" placeholder="Email">
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Date de naissance</label>
                                    <input name="BDate" class="form-control" type="text" placeholder="Date de naissance">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label>Adresse</label>
                                    <input name="address" class="form-control" type="text" placeholder="Adresse">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-5">
                                    <label>Numéro de téléphone</label>
                                    <input name="tel" class="form-control" type="tel" placeholder="+XX X XX XX XX XX">
                                </div>
                                <div class="form-group col-md-7" style="align-self: flex-end;">
                                    <p class="success" style="color:green;">${ success }</p>
                                </div>
                            </div>
                        </form>
                        <div class="row mar-none">
                            <p class="warning" style="color:red;">${ error }</p>
                        </div>
                        <div class="row mar-t-none">
                            <div class="col al-center">
                                <a href="/etablissement/students_menu" class="btn btn-primary">Annuler</a>
                            </div>
                            <div class="col al-center">
                                <button formmethod="post" form="userform" type="submit" class="btn btn-warning">Modifier</button>
                            </div>
                            <div class="col al-center">
                                <form action="/etablissement/students_remove" method="post" id="userDel">
                                    <input type="hidden" name="email"/>
                                    <button id="delBtn" class="btn btn-danger" form="userDel" type="submit">Supprimer</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
        <script src="js/app.js"></script>
    </body>
</html>