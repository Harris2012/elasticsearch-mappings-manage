function AliasUpdateModal($scope, $uibModalInstance, id, clusterId, documentId) {

    $scope.id = id;

    $scope.clusterId = clusterId;
    $scope.documentId = documentId;

    $scope.closeModal = function () {
        $uibModalInstance.dismiss("cancel");
    }

    $scope.confirmModal = function () {
        if ($scope.api == null) {
            return;
        }
        if ($scope.api.confirmUpdate == null) {
            return;
        }
        $scope.api.confirmUpdate(function () {
            $uibModalInstance.close("success");
        });
    }
}
