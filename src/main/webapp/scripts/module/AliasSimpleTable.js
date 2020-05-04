function AliasSimpleTable(ElasticsearchManageService, $uibModal) {

    function function_link(scope, element, attrs) {

        function function_reload_method(newValue) {
            if (newValue) {
                scope.reload = false;
                scope.refresh();
            }
        }

        function alias_items_callback(response) {
            scope.items_loaded = true;
            if (response.status != 1) {
                scope.items_message = response.message;
                return;
            }
            scope.items = response.items;
        }

        function alias_count_callback(response) {
            scope.count_loaded = true;
            if (response.status != 1) {
                scope.count_message = response.message;
                return;
            }
            scope.totalCount = response.totalCount;
        }

        function alias_disable_callback(response) {
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
                templateUrl: 'scripts/modal/AliasItemModal.html?v=' + window.releaseNo,
                controller: AliasItemModal,
                resolve: {
                    clusterId: function () { return scope.clusterId },
                    documentId: function () { return scope.documentId },
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
                templateUrl: 'scripts/modal/AliasUpdateModal.html?v=' + window.releaseNo,
                controller: AliasUpdateModal,
                resolve: {
                    clusterId: function () { return scope.clusterId },
                    documentId: function () { return scope.documentId },
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
            request.clusterId = scope.clusterId;
            request.documentId = scope.documentId;
            request.pageIndex = scope.currentPage;
            ElasticsearchManageService.alias_items(request).then(alias_items_callback);
        }

        function disable(id) {
            ElasticsearchManageService.alias_disable({ id: id }).then(alias_disable_callback);
        }

        function refresh() {
            {
                var request = {};
                request.clusterId = scope.clusterId;
                request.documentId = scope.documentId;
                ElasticsearchManageService.alias_count(request).then(alias_count_callback);
            }
            {
                var request = {};
                request.clusterId = scope.clusterId;
                request.documentId = scope.documentId;
                request.pageIndex = scope.currentPage;
                ElasticsearchManageService.alias_items(request).then(alias_items_callback);
            }
        }

        scope.$watch('reload', function_reload_method);
        scope.openItem = openItem;
        scope.openUpdate = openUpdate;
        scope.pageChanged = pageChanged;
        scope.disable = disable;
        scope.refresh = refresh;
        scope.clusterId = Number(attrs.clusterId);
        scope.documentId = Number(attrs.documentId);
        {
            scope.maxSize = 10;
            scope.currentPage = 1;
            scope.pageSize = 20;
            scope.refresh();
        }
    }

    return {
        restrict: 'E',
        templateUrl: 'scripts/module/AliasSimpleTable.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        scope: {
            reload: '=reload'
        }
    }
}
