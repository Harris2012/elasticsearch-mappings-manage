function AliasUpdateModule(ElasticsearchManageService, $convertor) {

    function function_link(scope, element, attrs) {

        function alias_empty_callback(response, callback) {
            if (response.status != 1) {
                return;
            }
            if (callback != null) {
                callback();
            }
        }

        function alias_basic_callback(response, callback) {
            scope.loaded = true;
            if (response.status != 1) {
                return;
            }
            scope.item = response.item;

            if (callback != null) {
                callback();
            }
        }

        function alias_basic() {
            ElasticsearchManageService.alias_basic({ id: scope.id }).then(function (response) {
                alias_basic_callback(response, alias_assign)
            });
        }

        function alias_assign() {
        }

        function alias_empty() {
            ElasticsearchManageService.alias_empty({}).then(function (response) {
                alias_empty_callback(response, alias_basic);
            });
        }

        scope.clusterId = Number(attrs.clusterId);
        scope.documentId = Number(attrs.documentId);

        scope.id = Number(attrs.id);
        alias_empty();
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

            ElasticsearchManageService.alias_update(request).then(function (response) {
                alias_update_callback(response, updateSuccessCallback);
            });
        }

        function alias_update_callback(response, updateSuccessCallback) {

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
        templateUrl: 'scripts/module/AliasUpdateModule.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        controller: function_controller,
        scope: {
            api: '='
        }
    }
}
