function DocumentUpdateModule(ElasticsearchManageService, $convertor) {

    function function_link(scope, element, attrs) {

        function document_empty_callback(response, callback) {
            if (response.status != 1) {
                return;
            }
            if (callback != null) {
                callback();
            }
        }

        function document_basic_callback(response, callback) {
            scope.loaded = true;
            if (response.status != 1) {
                return;
            }
            scope.item = response.item;

            if (callback != null) {
                callback();
            }
        }

        function document_basic() {
            ElasticsearchManageService.document_basic({ id: scope.id }).then(function (response) {
                document_basic_callback(response, document_assign)
            });
        }

        function document_assign() {
        }

        function document_empty() {
            ElasticsearchManageService.document_empty({}).then(function (response) {
                document_empty_callback(response, document_basic);
            });
        }

        scope.clusterId = Number(attrs.clusterId);

        scope.id = Number(attrs.id);
        document_empty();
    }

    function function_controller($scope) {

        function api_confirm_update(updateSuccessCallback) {


            $scope.waiting = true;
            $scope.message = null;

            var request = {};
            request.id = $scope.item.id;
            var requestItem = request.item = {};
            request.clusterId = $scope.clusterId;
            requestItem.name = $scope.item.name;
            requestItem.remark = $scope.item.remark;
            requestItem.numberOfShards = $scope.item.numberOfShards;
            requestItem.numberOfReplicas = $scope.item.numberOfReplicas;
            requestItem.mappingTotalFieldsLimit = $scope.item.mappingTotalFieldsLimit;
            requestItem.dynamic = $scope.item.dynamic;

            ElasticsearchManageService.document_update(request).then(function (response) {
                document_update_callback(response, updateSuccessCallback);
            });
        }

        function document_update_callback(response, updateSuccessCallback) {

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
        templateUrl: 'scripts/module/DocumentUpdateModule.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        controller: function_controller,
        scope: {
            api: '='
        }
    }
}
