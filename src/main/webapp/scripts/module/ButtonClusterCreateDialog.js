function ButtonClusterCreateDialog($uibModal) {

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
                templateUrl: 'scripts/modal/ClusterCreateModal.html?v=' + window.releaseNo,
                controller: ClusterCreateModal
            }
            var modalInstance = $uibModal.open(parameter);
            modalInstance.result.then(modalInstanceResultSuccess, modalInstanceResultFailed)
        }

        scope.openCreate = openCreate;
    }

    return {
        restrict: 'E',
        templateUrl: 'scripts/module/ButtonClusterCreateDialog.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        scope: {
            success: '=success'
        }
    }
}
