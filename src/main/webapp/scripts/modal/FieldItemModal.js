function FieldItemModal($scope, $uibModalInstance, id, clusterId, documentId) {

    $scope.id = id;

    $scope.clusterId = clusterId;
    $scope.documentId = documentId;

    $scope.closeModal = function () {
        $uibModalInstance.dismiss("cancel");
    }
}
