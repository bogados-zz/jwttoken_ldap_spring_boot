appChart = null;
$(document).ready(function(){
    $("#loginForm").submit(function (event) {
        event.preventDefault();

        var $form = $(this);
        var formData = {
            username: $form.find('input[name="username"]').val(),
            password: $form.find('input[name="password"]').val()
        };

        doLogin(formData);
    });

    $('.logout').on('click',function(){
        doLogout();
        setLogin();
    });

    if (getJwtToken()) {
        setPrincipal();
    } else {
        setLogin();
    }
});

$(document).ajaxError(function (event, jqXHR, ajaxSettings, thrownError) {
    if(jqXHR.status == 401 && getJwtToken()){
        $('#messages').html('<div class="alert alert-warning alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><i class="fa fa-warning"></i> Su sesion ha expirado.</div>');
        $('.logout').click();
    }
});

function doLogin(loginData) {
    $.ajax({
        url: "/auth",
        type: "POST",
        data: JSON.stringify(loginData),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data, textStatus, jqXHR) {
            setJwtToken(data.token);
            $('#messages').html('');
            setPrincipal();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            if (jqXHR.status === 401) {
                $('#messages').html('<div class="alert alert-danger alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><i class="fa fa-warning"></i> Nombre de usuario y/o contraseña incorrectos.</div>');
            } else {
                throw new Error("an unexpected error occured: " + errorThrown);
            }
        }
    });
}

function doLogout() {
    $("#loginForm")[0].reset();
    removeJwtToken();
}

function setPrincipal(){
    $("#login").hide();
    $('#reportes').show();
    $('body').removeClass('gray-bg');
    appChart = new AppChart();
    appChart.init();
}

function setLogin() {
    $('#reportes').hide();
    $("#login").show();
    $('body').addClass('gray-bg');
    appChart = null;
}