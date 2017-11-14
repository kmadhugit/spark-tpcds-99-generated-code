/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private long agg_bufValue;
/* 011 */   private scala.collection.Iterator inputadapter_input;
/* 012 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 013 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 014 */   private UnsafeRow agg_result;
/* 015 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 016 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 017 */
/* 018 */   public GeneratedIterator(Object[] references) {
/* 019 */     this.references = references;
/* 020 */   }
/* 021 */
/* 022 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 023 */     partitionIndex = index;
/* 024 */     this.inputs = inputs;
/* 025 */     agg_initAgg = false;
/* 026 */
/* 027 */     inputadapter_input = inputs[0];
/* 028 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 029 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 030 */     agg_result = new UnsafeRow(1);
/* 031 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 032 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 033 */
/* 034 */   }
/* 035 */
/* 036 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 037 */     // initialize aggregation buffer
/* 038 */     agg_bufIsNull = false;
/* 039 */     agg_bufValue = 0L;
/* 040 */
/* 041 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 042 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 043 */       long inputadapter_value = inputadapter_row.getLong(0);
/* 044 */
/* 045 */       // do aggregate
/* 046 */       // common sub-expressions
/* 047 */
/* 048 */       // evaluate aggregate function
/* 049 */       boolean agg_isNull3 = false;
/* 050 */
/* 051 */       long agg_value3 = -1L;
/* 052 */       agg_value3 = agg_bufValue + inputadapter_value;
/* 053 */       // update aggregation buffer
/* 054 */       agg_bufIsNull = false;
/* 055 */       agg_bufValue = agg_value3;
/* 056 */       if (shouldStop()) return;
/* 057 */     }
/* 058 */
/* 059 */   }
/* 060 */
/* 061 */   protected void processNext() throws java.io.IOException {
/* 062 */     while (!agg_initAgg) {
/* 063 */       agg_initAgg = true;
/* 064 */       long agg_beforeAgg = System.nanoTime();
/* 065 */       agg_doAggregateWithoutKey();
/* 066 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 067 */
/* 068 */       // output the result
/* 069 */
/* 070 */       agg_numOutputRows.add(1);
/* 071 */       agg_rowWriter.zeroOutNullBytes();
/* 072 */
/* 073 */       if (agg_bufIsNull) {
/* 074 */         agg_rowWriter.setNullAt(0);
/* 075 */       } else {
/* 076 */         agg_rowWriter.write(0, agg_bufValue);
/* 077 */       }
/* 078 */       append(agg_result);
/* 079 */     }
/* 080 */   }
/* 081 */ }
