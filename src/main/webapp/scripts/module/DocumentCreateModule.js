function DocumentCreateModule(ElasticsearchManageService, $convertor) {

    function function_link(scope, element, attrs) {

        function document_empty_callback(response, callback) {
            if (response.status != 1) {
                return;
            }
            if (callback != null) {
                callback();
            }
        }

        scope.clusterId = Number(attrs.clusterId);

        ElasticsearchManageService.document_empty({}).then(document_empty_callback);
    }

    function function_controller($scope) {

        function api_confirm_create(createSuccessCallback) {

            $scope.waiting = true;
            $scope.message = null;

            var request = {};
            var requestItem = request.item = {};
            request.clusterId = $scope.clusterId;
            requestItem.name = $scope.item.name;
            requestItem.remark = $scope.item.remark;
            requestItem.numberOfShards = $scope.item.numberOfShards;
            requestItem.numberOfReplicas = $scope.item.numberOfReplicas;
            requestItem.mappingTotalFieldsLimit = $scope.item.mappingTotalFieldsLimit;
            requestItem.dynamic = $scope.item.dynamic;

            ElasticsearchManageService.document_create(request).then(function (response) {
                document_create_callback(response, createSuccessCallback);
            });
        }

        function document_create_callback(response, createSuccessCallback) {

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
        templateUrl: 'scripts/module/DocumentCreateModule.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        controller: function_controller,
        scope: {
            api: '='
        }
    }
}
