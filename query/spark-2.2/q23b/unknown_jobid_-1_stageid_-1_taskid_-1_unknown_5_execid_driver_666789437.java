/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private double agg_bufValue;
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
/* 038 */     final double agg_value = -1.0;
/* 039 */     agg_bufIsNull = true;
/* 040 */     agg_bufValue = agg_value;
/* 041 */
/* 042 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 043 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 044 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 045 */       double inputadapter_value = inputadapter_isNull ? -1.0 : (inputadapter_row.getDouble(0));
/* 046 */
/* 047 */       // do aggregate
/* 048 */       // common sub-expressions
/* 049 */
/* 050 */       // evaluate aggregate function
/* 051 */       boolean agg_isNull3 = agg_bufIsNull;
/* 052 */       double agg_value3 = agg_bufValue;
/* 053 */
/* 054 */       if (!inputadapter_isNull && (agg_isNull3 ||
/* 055 */           (org.apache.spark.util.Utils.nanSafeCompareDoubles(inputadapter_value, agg_value3)) > 0)) {
/* 056 */         agg_isNull3 = false;
/* 057 */         agg_value3 = inputadapter_value;
/* 058 */       }
/* 059 */       // update aggregation buffer
/* 060 */       agg_bufIsNull = agg_isNull3;
/* 061 */       agg_bufValue = agg_value3;
/* 062 */       if (shouldStop()) return;
/* 063 */     }
/* 064 */
/* 065 */   }
/* 066 */
/* 067 */   protected void processNext() throws java.io.IOException {
/* 068 */     while (!agg_initAgg) {
/* 069 */       agg_initAgg = true;
/* 070 */       long agg_beforeAgg = System.nanoTime();
/* 071 */       agg_doAggregateWithoutKey();
/* 072 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 073 */
/* 074 */       // output the result
/* 075 */
/* 076 */       agg_numOutputRows.add(1);
/* 077 */       agg_rowWriter.zeroOutNullBytes();
/* 078 */
/* 079 */       if (agg_bufIsNull) {
/* 080 */         agg_rowWriter.setNullAt(0);
/* 081 */       } else {
/* 082 */         agg_rowWriter.write(0, agg_bufValue);
/* 083 */       }
/* 084 */       append(agg_result);
/* 085 */     }
/* 086 */   }
/* 087 */ }
