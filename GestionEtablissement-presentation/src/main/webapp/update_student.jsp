<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/padding.css">
        <link rel="stylesheet" href="css/margin.css">
        <link rel="stylesheet" href="css/outline-hover.css">
        <title>Title</title>
    </head>
    <body>
        <div class="form-row">
            <div class="form-group col-md-6">
                <div class="container conform">
                    <div class="cst-form">
                        <div class="row">
                            <h1 class="form-title">Modifier un étudiant</h1>
                        </div>
                        <form class="container-fluid" action="/etablissement/students_update" id="userform">
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
                                    <input name="BDate" class="form-control" type="date" placeholder="Date de naissance">
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
                            </div>
                        </form>
                        <div class="row  mar-none">
                            <p class="warning">${ error }</p>
                        </div>
                        <div class="row mar-t-none">
                            <div class="col al-center">
                                <a href="/etablissement/students_menu" class="btn btn-primary">Annuler</a>
                            </div>
                            <div class="col al-center">
                                <button formmethod="post" form="userform" type="submit" class="btn btn-outline-primary">Modifier</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group col-md-6">
                <div class="container-fluid">
                    <div class="container-fluid maxheight">
                        <div class="row">
                            <p class="warning" style="color:red;">${ error }</p>
                        </div>
                        <h1 style="color:white; text-align: center;">Liste des étudiants</h1>

                            <div name="container-fluid">
                            <div class="row col-md-12 mar-b-none mar-t-2 mar-l-none pad-none">
                                <div class="col-md-3 form-control lf bg-list-head text-white">
                                    <label>Nome</label>
                                </div>
                                <div class="col-md-3 form-control mid bg-list-head text-white">
                                    <label>Prenom</label>
                                </div>
                                <div class="col-md-6 form-control rt wd-250 bg-list-head text-white">
                                    <label>Email</label>
                                </div>
                            </div>

                        <c:forEach items="${students}" var="student">
                            <form name="form" class="form-group mar-none" method="GET" action="/etablissement/students_change">
                                    <div class="parent row col-md-12 mar-none pad-none">
                                        <div class="col-md-3 form-control lf hov-out-lf-sec">
                                            <label><c:out value="${student.getLastname()}"/></label>
                                            <input type="submit" name="lastname" readonly="true" hidden="true"></input>
                                        </div>
                                        <div class="col-md-3 form-control mid hov-out-md-sec">
                                            <label><c:out value="${student.getFirstname()}"/></label>
                                            <input type="submit" name="firstname" readonly="true" hidden="true"></input>
                                        </div>
                                        <div class="col-md-6 form-control rt wd-250 hov-out-rg-sec">
                                            <label><c:out value="${student.getMailAddress()}"/></label>
                                            <input type="submit" name="email" readonly="true" hidden="true"></input>
                                        </div>
                                    </div>
                                </a>
                            </form>
                        </c:forEach>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
    </body>
</html>