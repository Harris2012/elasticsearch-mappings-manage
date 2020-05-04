function ClusterUpdateModule(ElasticsearchManageService, $convertor) {

    function function_link(scope, element, attrs) {

        function cluster_empty_callback(response, callback) {
            if (response.status != 1) {
                return;
            }
            if (callback != null) {
                callback();
            }
        }

        function cluster_basic_callback(response, callback) {
            scope.loaded = true;
            if (response.status != 1) {
                return;
            }
            scope.item = response.item;

            if (callback != null) {
                callback();
            }
        }

        function cluster_basic() {
            ElasticsearchManageService.cluster_basic({ id: scope.id }).then(function (response) {
                cluster_basic_callback(response, cluster_assign)
            });
        }

        function cluster_assign() {
        }

        function cluster_empty() {
            ElasticsearchManageService.cluster_empty({}).then(function (response) {
                cluster_empty_callback(response, cluster_basic);
            });
        }

        scope.id = Number(attrs.id);
        cluster_empty();
    }

    function function_controller($scope) {

        function api_confirm_update(updateSuccessCallback) {


            $scope.waiting = true;
            $scope.message = null;

            var request = {};
            request.id = $scope.item.id;
            var requestItem = request.item = {};
            requestItem.name = $scope.item.name;
            requestItem.remark = $scope.item.remark;

            ElasticsearchManageService.cluster_update(request).then(function (response) {
                cluster_update_callback(response, updateSuccessCallback);
            });
        }

        function cluster_update_callback(response, updateSuccessCallback) {

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
        templateUrl: 'scripts/module/ClusterUpdateModule.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        controller: function_controller,
        scope: {
            api: '='
        }
    }
}
