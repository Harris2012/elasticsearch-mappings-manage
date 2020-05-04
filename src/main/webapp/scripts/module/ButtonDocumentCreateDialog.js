function ButtonDocumentCreateDialog($uibModal) {

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
                templateUrl: 'scripts/modal/DocumentCreateModal.html?v=' + window.releaseNo,
                controller: DocumentCreateModal,
                resolve: {
                    clusterId: function () { return scope.clusterId }
                }
            }
            var modalInstance = $uibModal.open(parameter);
            modalInstance.result.then(modalInstanceResultSuccess, modalInstanceResultFailed)
        }

        scope.clusterId = attrs.clusterId;
        scope.openCreate = openCreate;
    }

    return {
        restrict: 'E',
        templateUrl: 'scripts/module/ButtonDocumentCreateDialog.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        scope: {
            success: '=success'
        }
    }
}
