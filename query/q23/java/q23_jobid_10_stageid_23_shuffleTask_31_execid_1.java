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
/* 042 */     while (inputadapter_input.hasNext()) {
/* 043 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 044 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 045 */       double inputadapter_value = inputadapter_isNull ? -1.0 : (inputadapter_row.getDouble(0));
/* 046 */
/* 047 */       // do aggregate
/* 048 */       // common sub-expressions
/* 049 */
/* 050 */       // evaluate aggregate function
/* 051 */       boolean agg_isNull2 = true;
/* 052 */       double agg_value2 = -1.0;
/* 053 */
/* 054 */       boolean agg_isNull3 = agg_bufIsNull;
/* 055 */       double agg_value3 = agg_bufValue;
/* 056 */       if (agg_isNull3) {
/* 057 */         boolean agg_isNull5 = false;
/* 058 */         double agg_value5 = -1.0;
/* 059 */         if (!false) {
/* 060 */           agg_value5 = (double) 0;
/* 061 */         }
/* 062 */         if (!agg_isNull5) {
/* 063 */           agg_isNull3 = false;
/* 064 */           agg_value3 = agg_value5;
/* 065 */         }
/* 066 */       }
/* 067 */
/* 068 */       boolean agg_isNull7 = inputadapter_isNull;
/* 069 */       double agg_value7 = -1.0;
/* 070 */       if (!inputadapter_isNull) {
/* 071 */         agg_value7 = inputadapter_value;
/* 072 */       }
/* 073 */       if (!agg_isNull7) {
/* 074 */         agg_isNull2 = false; // resultCode could change nullability.
/* 075 */         agg_value2 = agg_value3 + agg_value7;
/* 076 */
/* 077 */       }
/* 078 */       boolean agg_isNull1 = agg_isNull2;
/* 079 */       double agg_value1 = agg_value2;
/* 080 */       if (agg_isNull1) {
/* 081 */         if (!agg_bufIsNull) {
/* 082 */           agg_isNull1 = false;
/* 083 */           agg_value1 = agg_bufValue;
/* 084 */         }
/* 085 */       }
/* 086 */       // update aggregation buffer
/* 087 */       agg_bufIsNull = agg_isNull1;
/* 088 */       agg_bufValue = agg_value1;
/* 089 */       if (shouldStop()) return;
/* 090 */     }
/* 091 */
/* 092 */   }
/* 093 */
/* 094 */   protected void processNext() throws java.io.IOException {
/* 095 */     while (!agg_initAgg) {
/* 096 */       agg_initAgg = true;
/* 097 */       long agg_beforeAgg = System.nanoTime();
/* 098 */       agg_doAggregateWithoutKey();
/* 099 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 100 */
/* 101 */       // output the result
/* 102 */
/* 103 */       agg_numOutputRows.add(1);
/* 104 */       agg_rowWriter.zeroOutNullBytes();
/* 105 */
/* 106 */       if (agg_bufIsNull) {
/* 107 */         agg_rowWriter.setNullAt(0);
/* 108 */       } else {
/* 109 */         agg_rowWriter.write(0, agg_bufValue);
/* 110 */       }
/* 111 */       append(agg_result);
/* 112 */     }
/* 113 */   }
/* 114 */ }
