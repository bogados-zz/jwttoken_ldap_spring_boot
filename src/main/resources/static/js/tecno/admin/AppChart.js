function AppChart(){
    _this = this;
    this.server = 'http://localhost:8080/admin/api';
    this.data;
    this.path;
    this.message;

    $('.boton-chart').on('click',function(){
        var boton = $(this);
        var rango = boton.data('rango');
        _this.defaultValues();
        _this.data = null;
        switch(rango){
            case 'diario':
                _this.loadDailyChart(_this.currentDay());
                break;
            case 'semanal':
                _this.loadWeeklyChart(_this.currentWeek());
                break;
            case 'mensual':
                _this.loadMonthlyChart(_this.currentMonth());
                break;
            case 'anual':
                _this.loadAnnualChart(_this.currentYear());
                break;
            default:
                _this.loadDailyChart(_this.currentDay());
                break;
        }
    });

    this.init = function(){
        _this.defaultValues();
        _this.initDaily();
        _this.initWeekly();        
        _this.initMonthly();
        _this.initAnnual();
    };

    this.defaultValues = function(){
        _this.currentDay();
        $('#diario').val(_this.data.date);
        value = _this.data.date;
        firstDate = moment(value, "DD-MM-YYYY").day(0).format("DD-MM-YYYY");
        lastDate =  moment(value, "DD-MM-YYYY").day(6).format("DD-MM-YYYY");
        $("#semanal").val(firstDate + "   -   " + lastDate);
        $('#mensual').val(_this.data.date.substring(3,10));
        $('#anual').val(_this.data.date.substring(6,10));
    };

    this.initDaily = function(){
        $('#diario').datepicker({
            todayBtn: "linked",
            keyboardNavigation: false,
            forceParse: false,
            calendarWeeks: true,
            autoclose: true,
            format: 'dd-mm-yyyy'
        });

        $('#diario').on('changeDate',function(){
            _this.data = {
                date: $('#diario').val()
            };
            _this.loadDailyChart(_this.data);
        });

        _this.loadDailyChart();
    };

    this.initWeekly = function(){
        $('#semanal').datetimepicker({
            format: 'DD-MM-YYYY'
        });

        $('#semanal').on('dp.change', function (e) {
            value = $("#semanal").val();
            firstDate = moment(value, "DD-MM-YYYY").day(0).format("DD-MM-YYYY");
            lastDate =  moment(value, "DD-MM-YYYY").day(6).format("DD-MM-YYYY");
            $("#semanal").val(firstDate + "   -   " + lastDate);
            if(firstDate != _this.data.from){
                _this.data = {
                    from: firstDate,
                    to: lastDate
                }
                _this.loadWeeklyChart();
            }
        });
    };

    this.initMonthly = function(){
        $('#mensual').datepicker({
            minViewMode: 1,
            keyboardNavigation: false,
            forceParse: false,
            autoclose: true,
            todayHighlight: true,
            format: 'mm-yyyy'    
        });

        $('#mensual').on('changeDate',function(){
            var month = $('#mensual').val().substring(0,2);
            var year = $('#mensual').val().substring(3,8);
            _this.data = {
                month: month,
                year: year 
            };
            _this.loadMonthlyChart();
        });
    };

    this.initAnnual = function(){
        $('#anual').datepicker({
            startView: 2,
            todayBtn: "linked",
            keyboardNavigation: false,
            forceParse: false,
            autoclose: true,
            format: 'yyyy',
            viewMode: "years", 
            minViewMode: "years"
        });

        $('#anual').on('changeDate',function(){
            var year = $('#anual').val();
            _this.data = {
                year: year
            };
            _this.loadAnnualChart();
        });
    };

    this.loadChart = function(isList, isWeek){
        var response = _this.callAjax(isList, isWeek);
        if(!isList)
            var chart = _this.processBarChartData(response);
        else
            var chart = _this.processMultiBarChartData(response);

        $('#title').text(_this.message);
        c3.generate(chart);
    }

    this.loadDailyChart = function(show){
        $('.diario-group').show();
        $('.semanal-group').hide();
        $('.mensual-group').hide();
        $('.anual-group').hide();
        $('.li-diario').addClass('active');
        $('.li-semanal').removeClass('active');
        $('.li-mensual').removeClass('active');
        $('.li-anual').removeClass('active');
        _this.path = '/reportes/diario';
        _this.message = 'Reporte Diario: ' + _this.data.date;
        _this.loadChart();
    };

    this.loadWeeklyChart = function(){
        $('.diario-group').hide();
        $('.semanal-group').show();
        $('.mensual-group').hide();
        $('.anual-group').hide();
        $('.li-diario').removeClass('active');
        $('.li-semanal').addClass('active');
        $('.li-mensual').removeClass('active');
        $('.li-anual').removeClass('active');
        _this.path = '/reporte_detallado/semanal';
        _this.message = 'Reporte Semanal: ' + _this.data.from + ' - ' + _this.data.to;
        _this.loadChart(true, true);
    };

    this.loadMonthlyChart = function(){
        $('.diario-group').hide();
        $('.semanal-group').hide();
        $('.mensual-group').show();
        $('.anual-group').hide();
        $('.li-diario').removeClass('active');
        $('.li-semanal').removeClass('active');
        $('.li-mensual').addClass('active');
        $('.li-anual').removeClass('active');
        _this.path = '/reportes/mensual';
        _this.message = 'Reporte Mensual: ' + (_this.data.month) + '-' + _this.data.year;
        _this.loadChart();
    };

    this.loadAnnualChart = function(){
        $('.diario-group').hide();
        $('.semanal-group').hide();
        $('.mensual-group').hide();
        $('.anual-group').show();
        $('.li-diario').removeClass('active');
        $('.li-semanal').removeClass('active');
        $('.li-mensual').removeClass('active');
        $('.li-anual').addClass('active');
        _this.path = '/reporte_detallado/anual';
        _this.message = 'Reporte Anual: ' + _this.data.year;
        _this.loadChart(true);
    };

    this.callAjax = function(){
        var responseData = null;
        $.ajax({
            url: _this.server + _this.path + "?" + $.param(_this.data),
            type: 'GET',
            headers: createAuthorizationTokenHeader(),
            async: false,
            success: function(response){
                responseData = response;
            },
            error: function(response){
                console.log(response);
            }
        });
        return responseData;
    };

    this.callAjaxMock = function(isList, isWeek){
        if(isList){
            var response = [{
                periodo: isWeek ? 'Lunes' : 'Enero',
                positivos: numberRandom(),
                negativos: numberRandom(),
                total: 30
            },
            {
                periodo: isWeek ? 'Martes' : 'Febrero',
                positivos: numberRandom(),
                negativos: numberRandom(),
                total: 30
            },
            {
                periodo: isWeek ? 'Miercoles' : 'Marzo',
                positivos: numberRandom(),
                negativos: numberRandom(),
                total: 38
            },
            {
                periodo: isWeek ? 'Jueves' : 'Abril',
                positivos: numberRandom(),
                negativos: numberRandom(),
                total: 38
            },
            {
                periodo: isWeek ? 'Viernes' : 'Mayo',
                positivos: numberRandom(),
                negativos: numberRandom(),
                total: 38
            }];
        }else{
            var response = {
                positivos: numberRandom(),
                negativos: numberRandom(),
                total: 30
            };
        }
        return response;
    };

    this.processBarChartData = function(response){
        var positivos = ['Positivos', response.positivos];
        var negativos = ['Negativos', response.negativos];
        var c3 = {
            data: {
                bindto: '#chart',
                columns: [
                    positivos,
                    negativos
                ],
                colors:{
                    Positivos: '#23c6c8',
                    Negativos: '#ed5565'
                },
                type: 'bar'
            },
            bar: {
                width: {
                    ratio: 0.5
                }
            }
        };
        return c3;
    };

    this.processMultiBarChartData = function(response){
        var x = new Array();
        var negativos = new Array();
        var positivos = new Array();
        x.push('x');
        positivos.push('Positivos');
        negativos.push('Negativos');

        $.each(response,function(i,v){
            x.push(v.periodo);
            positivos.push(v.positivos);
            negativos.push(v.negativos);
        });

        var c3 = {
            data: {
                bindto: '#chart',
                x: 'x',
                columns: [
                    x,
                    positivos,
                    negativos
                ],
                colors:{
                    Positivos: '#23c6c8',
                    Negativos: '#ed5565'
                },
                type: 'bar'
            },
            axis: {
                x: {
                    type: 'category'
                }
            }
        };
        return c3;
    };

    this.currentDay = function(){
        _this.data = {};
        _this.data.date = (new Date()).ddmmyyyy();
    };

    this.currentWeek = function(){
        _this.data = {};
        var curr = new Date;
        var first = curr.getDate() - curr.getDay();
        var last = first + 6;
        _this.data.from = (new Date(curr.setDate(first))).ddmmyyyy();
        _this.data.to = (new Date(curr.setDate(last))).ddmmyyyy();
    };

    this.currentMonth = function(){
        _this.data = {};
        var date = new Date(), y = date.getFullYear(), m = date.getMonth();
        _this.data.month = (new Date(y, m, 1)).getMonth() + 1;
        _this.data.year = (new Date(y, m + 1, 0)).getFullYear();
    };

    this.currentYear = function(){
        _this.data = {};
        _this.data.year = (new Date()).getFullYear();
    }
}

Date.prototype.ddmmyyyy = function() {
    var mm = this.getMonth() + 1;
    var dd = this.getDate();
    return [dd < 10 ? '0'.concat(dd) : dd, '-', mm < 10 ? '0'.concat(mm) : mm, '-', this.getFullYear()].join('');
};

function numberRandom(){
    return Math.floor(Math.random() * 20) + 1;
}