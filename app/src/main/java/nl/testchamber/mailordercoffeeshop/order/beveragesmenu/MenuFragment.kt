package nl.testchamber.mailordercoffeeshop.order.beveragesmenu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import nl.testchamber.mailordercoffeeshop.R
import nl.testchamber.mailordercoffeeshop.data.beverage.BeverageMenuItem
import nl.testchamber.mailordercoffeeshop.order.OrderViewModel


/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [MenuFragment.OnListFragmentInteractionListener] interface.
 */
class MenuFragment : androidx.fragment.app.Fragment() {

    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    private lateinit var viewModel: OrderViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(activity!!).get(OrderViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_beverage_list, container, false)

        // Set the adapter
        if (view is androidx.recyclerview.widget.RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> androidx.recyclerview.widget.LinearLayoutManager(context)
                    else -> androidx.recyclerview.widget.GridLayoutManager(context, columnCount)
                }
                adapter = MyBeverageRecyclerViewAdapter(BeveragesMenuContent.ITEMS, listener)
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.isMenuFragmentActive.set(true)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(beverageMenuItem: BeverageMenuItem)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.isMenuFragmentActive.set(false)
    }

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        fun newInstance(): MenuFragment {
            return MenuFragment()
        }

        val FRAGMENT_TAG = "FRAGMENT_TAG:${MenuFragment::class.java.simpleName}"
    }
}
