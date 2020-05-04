function ClusterSimpleTable(ElasticsearchManageService, $uibModal) {

    function function_link(scope, element, attrs) {

        function function_reload_method(newValue) {
            if (newValue) {
                scope.reload = false;
                scope.refresh();
            }
        }

        function cluster_items_callback(response) {
            scope.items_loaded = true;
            if (response.status != 1) {
                scope.items_message = response.message;
                return;
            }
            scope.items = response.items;
        }

        function cluster_count_callback(response) {
            scope.count_loaded = true;
            if (response.status != 1) {
                scope.count_message = response.message;
                return;
            }
            scope.totalCount = response.totalCount;
        }

        function cluster_disable_callback(response) {
            if (response.status != 1) {
                return;
            }
            scope.pageChanged();
        }

        function openItem(id) {
            var parameter = {
                size: 'lg',
                animation: true,
                backdrop: 'static',
                templateUrl: 'scripts/modal/ClusterItemModal.html?v=' + window.releaseNo,
                controller: ClusterItemModal,
                resolve: {
                    id: function () { return id; }
                }
            }
            var modalInstance = $uibModal.open(parameter);
            modalInstance.result.then(function (response) { }, function () { });
        }

        function openUpdate(id) {
            var parameter = {
                size: 'lg',
                animation: true,
                backdrop: 'static',
                templateUrl: 'scripts/modal/ClusterUpdateModal.html?v=' + window.releaseNo,
                controller: ClusterUpdateModal,
                resolve: {
                    id: function () { return id; }
                }
            }
            var modalInstance = $uibModal.open(parameter);
            modalInstance.result.then(function (response) { scope.refresh(); }, function () { });
        }

        function pageChanged() {
            scope.items_loaded = false;
            scope.items_message = null;
            var request = {};
            request.pageIndex = scope.currentPage;
            ElasticsearchManageService.cluster_items(request).then(cluster_items_callback);
        }

        function disable(id) {
            ElasticsearchManageService.cluster_disable({ id: id }).then(cluster_disable_callback);
        }

        function refresh() {
            {
                var request = {};
                ElasticsearchManageService.cluster_count(request).then(cluster_count_callback);
            }
            {
                var request = {};
                request.pageIndex = scope.currentPage;
                ElasticsearchManageService.cluster_items(request).then(cluster_items_callback);
            }
        }

        scope.$watch('reload', function_reload_method);
        scope.openItem = openItem;
        scope.openUpdate = openUpdate;
        scope.pageChanged = pageChanged;
        scope.disable = disable;
        scope.refresh = refresh;
        {
            scope.maxSize = 10;
            scope.currentPage = 1;
            scope.pageSize = 20;
            scope.refresh();
        }
    }

    return {
        restrict: 'E',
        templateUrl: 'scripts/module/ClusterSimpleTable.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        scope: {
            reload: '=reload'
        }
    }
}
