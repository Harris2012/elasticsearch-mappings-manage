function AliasListPage($scope, $stateParams) {
    function watchSuccess(newValue) {
        if (newValue) {
            $scope.success = false;
            $scope.reload = true;
        }
    }
    $scope.clusterId = $stateParams.clusterId;
    $scope.documentId = $stateParams.documentId;
    $scope.$watch('success', watchSuccess);
}
