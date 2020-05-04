function ClusterListPage($scope, $stateParams) {
    function watchSuccess(newValue) {
        if (newValue) {
            $scope.success = false;
            $scope.reload = true;
        }
    }
    $scope.$watch('success', watchSuccess);
}
