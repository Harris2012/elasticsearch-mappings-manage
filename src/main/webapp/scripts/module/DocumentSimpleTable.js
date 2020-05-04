function DocumentSimpleTable(ElasticsearchManageService, $uibModal) {

    function function_link(scope, element, attrs) {

        function function_reload_method(newValue) {
            if (newValue) {
                scope.reload = false;
                scope.refresh();
            }
        }

        function document_items_callback(response) {
            scope.items_loaded = true;
            if (response.status != 1) {
                scope.items_message = response.message;
                return;
            }
            scope.items = response.items;
        }

        function document_count_callback(response) {
            scope.count_loaded = true;
            if (response.status != 1) {
                scope.count_message = response.message;
                return;
            }
            scope.totalCount = response.totalCount;
        }

        function document_disable_callback(response) {
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
                templateUrl: 'scripts/modal/DocumentItemModal.html?v=' + window.releaseNo,
                controller: DocumentItemModal,
                resolve: {
                    clusterId: function () { return scope.clusterId },
                    id: function () { return id; }
                }
            }
            var modalInstance = $uibModal.open(parameter);
            modalInstance.result.then(function (response) { }, function () { });
        }

        function openPreview(id) {
            var parameter = {
                size: 'lg',
                animation: true,
                backdrop: 'static',
                templateUrl: 'scripts/modal/DocumentPreviewModal.html?v=' + window.releaseNo,
                controller: DocumentPreviewModal,
                resolve: {
                    clusterId: function () { return scope.clusterId },
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
                templateUrl: 'scripts/modal/DocumentUpdateModal.html?v=' + window.releaseNo,
                controller: DocumentUpdateModal,
                resolve: {
                    clusterId: function () { return scope.clusterId },
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
            request.pageIndex = scope.currentPage;
            ElasticsearchManageService.document_items(request).then(document_items_callback);
        }

        function disable(id) {
            ElasticsearchManageService.document_disable({ id: id }).then(document_disable_callback);
        }

        function refresh() {
            {
                var request = {};
                request.clusterId = scope.clusterId;
                ElasticsearchManageService.document_count(request).then(document_count_callback);
            }
            {
                var request = {};
                request.clusterId = scope.clusterId;
                request.pageIndex = scope.currentPage;
                ElasticsearchManageService.document_items(request).then(document_items_callback);
            }
        }

        scope.$watch('reload', function_reload_method);
        scope.openItem = openItem;
        scope.openPreview = openPreview;
        scope.openUpdate = openUpdate;
        scope.pageChanged = pageChanged;
        scope.disable = disable;
        scope.refresh = refresh;
        scope.clusterId = Number(attrs.clusterId);
        {
            scope.maxSize = 10;
            scope.currentPage = 1;
            scope.pageSize = 20;
            scope.refresh();
        }
    }

    return {
        restrict: 'E',
        templateUrl: 'scripts/module/DocumentSimpleTable.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        scope: {
            reload: '=reload'
        }
    }
}
