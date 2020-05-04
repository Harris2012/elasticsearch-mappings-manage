function FieldUpdateModule(ElasticsearchManageService, $convertor) {

    function function_link(scope, element, attrs) {

        function field_empty_callback(response, callback) {
            if (response.status != 1) {
                return;
            }
            scope.fieldType_selection = response.fieldType;
            if (callback != null) {
                callback();
            }
        }

        function field_basic_callback(response, callback) {
            scope.loaded = true;
            if (response.status != 1) {
                return;
            }
            scope.item = response.item;
            scope.fieldType_key = scope.item.fieldType;

            if (callback != null) {
                callback();
            }
        }

        function field_basic() {
            ElasticsearchManageService.field_basic({ id: scope.id }).then(function (response) {
                field_basic_callback(response, field_assign)
            });
        }

        function field_assign() {
            $convertor.setCurrent(scope, 'fieldType_current', 'fieldType_selection', 'fieldType_key', 'name');
        }

        function field_empty() {
            ElasticsearchManageService.field_empty({}).then(function (response) {
                field_empty_callback(response, field_basic);
            });
        }

        scope.clusterId = Number(attrs.clusterId);
        scope.documentId = Number(attrs.documentId);

        scope.id = Number(attrs.id);
        field_empty();
    }

    function function_controller($scope) {

        function api_confirm_update(updateSuccessCallback) {


            $scope.waiting = true;
            $scope.message = null;

            var request = {};
            request.id = $scope.item.id;
            var requestItem = request.item = {};
            request.clusterId = $scope.clusterId;
            request.documentId = $scope.documentId;
            requestItem.name = $scope.item.name;
            if ($scope.fieldType_current != null) {
                requestItem.fieldType = $scope.fieldType_current.name;
            }
            requestItem.remark = $scope.item.remark;
            requestItem.nullValue = $scope.item.nullValue;
            requestItem.copyTo = $scope.item.copyTo;

            ElasticsearchManageService.field_update(request).then(function (response) {
                field_update_callback(response, updateSuccessCallback);
            });
        }

        function field_update_callback(response, updateSuccessCallback) {

            $scope.waiting = false;

            if (response.status != 1) {
                $scope.message = response.message;
                return;
            }

            if (updateSuccessCallback != null) {
                updateSuccessCallback();
            }
        }

        $scope.api = {};
        $scope.api.confirmUpdate = api_confirm_update;
    }

    return {
        restrict: 'E',
        templateUrl: 'scripts/module/FieldUpdateModule.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        controller: function_controller,
        scope: {
            api: '='
        }
    }
}
