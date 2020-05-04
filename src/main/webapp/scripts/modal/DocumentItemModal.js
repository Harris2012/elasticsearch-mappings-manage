function DocumentItemModal($scope, $uibModalInstance, id, clusterId) {

    $scope.id = id;

    $scope.clusterId = clusterId;

    $scope.closeModal = function () {
        $uibModalInstance.dismiss("cancel");
    }
}
