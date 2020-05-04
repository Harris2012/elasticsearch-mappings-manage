function ClusterCreateModule(ElasticsearchManageService, $convertor) {

    function function_link(scope, element, attrs) {

        function cluster_empty_callback(response, callback) {
            if (response.status != 1) {
                return;
            }
            if (callback != null) {
                callback();
            }
        }

        ElasticsearchManageService.cluster_empty({}).then(cluster_empty_callback);
    }

    function function_controller($scope) {

        function api_confirm_create(createSuccessCallback) {

            $scope.waiting = true;
            $scope.message = null;

            var request = {};
            var requestItem = request.item = {};
            requestItem.name = $scope.item.name;
            requestItem.remark = $scope.item.remark;

            ElasticsearchManageService.cluster_create(request).then(function (response) {
                cluster_create_callback(response, createSuccessCallback);
            });
        }

        function cluster_create_callback(response, createSuccessCallback) {

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
        templateUrl: 'scripts/module/ClusterCreateModule.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        controller: function_controller,
        scope: {
            api: '='
        }
    }
}
