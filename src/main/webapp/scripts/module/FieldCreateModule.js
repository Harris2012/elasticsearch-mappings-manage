function FieldCreateModule(ElasticsearchManageService, $convertor) {

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

        scope.clusterId = Number(attrs.clusterId);
        scope.documentId = Number(attrs.documentId);

        ElasticsearchManageService.field_empty({}).then(field_empty_callback);
    }

    function function_controller($scope) {

        function api_confirm_create(createSuccessCallback) {

            $scope.waiting = true;
            $scope.message = null;

            var request = {};
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

            ElasticsearchManageService.field_create(request).then(function (response) {
                field_create_callback(response, createSuccessCallback);
            });
        }

        function field_create_callback(response, createSuccessCallback) {

            $scope.waiting = false;

            if (response.status != 1) {
                $scope.message = response.message;
                return;
            }

            if (createSuccessCallback != null) {
                createSuccessCallback();
            }
        }

        $scope.api = {};
        $scope.api.confirmCreate = api_confirm_create;
    }

    return {
        restrict: 'E',
        templateUrl: 'scripts/module/FieldCreateModule.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        controller: function_controller,
        scope: {
            api: '='
        }
    }
}
