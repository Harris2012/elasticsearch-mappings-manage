function ButtonFieldCreateDialog($uibModal) {

    function function_link(scope, element, attrs) {

        function openCreate() {

            function modalInstanceResultSuccess(response) {
                scope.success = true;
            }

            function modalInstanceResultFailed() {
            }

            var parameter = {
                size: 'lg',
                animation: true,
                backdrop: 'static',
                templateUrl: 'scripts/modal/FieldCreateModal.html?v=' + window.releaseNo,
                controller: FieldCreateModal,
                resolve: {
                    clusterId: function () { return scope.clusterId },
                    documentId: function () { return scope.documentId }
                }
            }
            var modalInstance = $uibModal.open(parameter);
            modalInstance.result.then(modalInstanceResultSuccess, modalInstanceResultFailed)
        }

        scope.clusterId = attrs.clusterId;
        scope.documentId = attrs.documentId;
        scope.openCreate = openCreate;
    }

    return {
        restrict: 'E',
        templateUrl: 'scripts/module/ButtonFieldCreateDialog.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        scope: {
            success: '=success'
        }
    }
}
