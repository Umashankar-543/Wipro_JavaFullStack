document.addEventListener('DOMContentLoaded', function() {
    const policies = [
        { id: 1, name: 'Health Insurance', status: 'Active', details: 'Comprehensive health insurance covering hospitalization and outpatient services.' },
        { id: 2, name: 'Car Insurance', status: 'Active', details: 'Full coverage car insurance including third-party liability and own damage cover.' },
        { id: 3, name: 'Home Insurance', status: 'Active', details: 'Protection against fire, theft, and natural disasters for your home.' },
        { id: 4, name: 'Life Insurance', status: 'Inactive', details: 'Term life insurance providing financial security for your family.' }
    ];

    const claims = [
        { id: 1, policyId: 1, status: 'Pending', details: 'Claim for hospitalization due to surgery.' },
        { id: 2, policyId: 2, status: 'Approved', details: 'Claim for car repair after accident.' },
        { id: 3, policyId: 3, status: 'Rejected', details: 'Claim for water damage in home.' },
        { id: 4, policyId: 4, status: 'Pending', details: 'Claim for term insurance benefit.' }
    ];

    function populatePolicies() {
        const container = document.getElementById('policiesContainer');
        let html = '';
        policies.forEach(policy => {
            html += `
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${policy.name}</h5>
                        <p class="card-text">Status: ${policy.status}</p>
                        <button class="btn btn-primary" onclick="viewPolicyDetails(${policy.id})">View Details</button>
                    </div>
                </div>
            `;
        });
        container.innerHTML = html;
    }

    function populateClaims() {
        const container = document.getElementById('claimsContainer');
        let html = '';
        claims.forEach(claim => {
            const policy = policies.find(p => p.id === claim.policyId);
            html += `
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${policy.name}</h5>
                        <p class="card-text">Status: ${claim.status}</p>
                        <button class="btn btn-primary" onclick="viewClaimDetails(${claim.id})">View Details</button>
                    </div>
                </div>
            `;
        });
        container.innerHTML = html;
    }

    window.viewPolicyDetails = function(policyId) {
        const policy = policies.find(p => p.id === policyId);
        const content = `
            <p>Name: ${policy.name}</p>
            <p>Status: ${policy.status}</p>
            <p>Details: ${policy.details}</p>
        `;
        document.getElementById('policyDetailContent').innerHTML = content;
        $('#policyDetailModal').modal('show');
    };

    window.viewClaimDetails = function(claimId) {
        const claim = claims.find(c => c.id === claimId);
        const policy = policies.find(p => p.id === claim.policyId);
        const content = `
            <p>Policy: ${policy.name}</p>
            <p>Status: ${claim.status}</p>
            <p>Details: ${claim.details}</p>
        `;
        document.getElementById('claimDetailContent').innerHTML = content;
        $('#claimDetailModal').modal('show');
    };

    function sortPoliciesByName() {
        policies.sort((a, b) => a.name.localeCompare(b.name));
        populatePolicies();
    }

    function sortClaimsByStatus() {
        claims.sort((a, b) => a.status.localeCompare(b.status));
        populateClaims();
    }

    document.getElementById('sortPoliciesByName').addEventListener('click', sortPoliciesByName);
    document.getElementById('sortClaimsByStatus').addEventListener('click', sortClaimsByStatus);

    populatePolicies();
    populateClaims();
});
