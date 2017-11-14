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
/* 051 */       boolean agg_isNull4 = true;
/* 052 */       double agg_value4 = -1.0;
/* 053 */
/* 054 */       boolean agg_isNull5 = agg_bufIsNull;
/* 055 */       double agg_value5 = agg_bufValue;
/* 056 */       if (agg_isNull5) {
/* 057 */         boolean agg_isNull7 = false;
/* 058 */         double agg_value7 = -1.0;
/* 059 */         if (!false) {
/* 060 */           agg_value7 = (double) 0;
/* 061 */         }
/* 062 */         if (!agg_isNull7) {
/* 063 */           agg_isNull5 = false;
/* 064 */           agg_value5 = agg_value7;
/* 065 */         }
/* 066 */       }
/* 067 */
/* 068 */       if (!inputadapter_isNull) {
/* 069 */         agg_isNull4 = false; // resultCode could change nullability.
/* 070 */         agg_value4 = agg_value5 + inputadapter_value;
/* 071 */
/* 072 */       }
/* 073 */       boolean agg_isNull3 = agg_isNull4;
/* 074 */       double agg_value3 = agg_value4;
/* 075 */       if (agg_isNull3) {
/* 076 */         if (!agg_bufIsNull) {
/* 077 */           agg_isNull3 = false;
/* 078 */           agg_value3 = agg_bufValue;
/* 079 */         }
/* 080 */       }
/* 081 */       // update aggregation buffer
/* 082 */       agg_bufIsNull = agg_isNull3;
/* 083 */       agg_bufValue = agg_value3;
/* 084 */       if (shouldStop()) return;
/* 085 */     }
/* 086 */
/* 087 */   }
/* 088 */
/* 089 */   protected void processNext() throws java.io.IOException {
/* 090 */     while (!agg_initAgg) {
/* 091 */       agg_initAgg = true;
/* 092 */       long agg_beforeAgg = System.nanoTime();
/* 093 */       agg_doAggregateWithoutKey();
/* 094 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 095 */
/* 096 */       // output the result
/* 097 */
/* 098 */       agg_numOutputRows.add(1);
/* 099 */       agg_rowWriter.zeroOutNullBytes();
/* 100 */
/* 101 */       if (agg_bufIsNull) {
/* 102 */         agg_rowWriter.setNullAt(0);
/* 103 */       } else {
/* 104 */         agg_rowWriter.write(0, agg_bufValue);
/* 105 */       }
/* 106 */       append(agg_result);
/* 107 */     }
/* 108 */   }
/* 109 */ }
