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
/* 017 */   private boolean locallimit_stopEarly;
/* 018 */   private int locallimit_count;
/* 019 */   private UnsafeRow locallimit_result;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder locallimit_holder;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter locallimit_rowWriter;
/* 022 */   private boolean globallimit_stopEarly;
/* 023 */   private int globallimit_count;
/* 024 */   private UnsafeRow globallimit_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder globallimit_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter globallimit_rowWriter;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     agg_initAgg = false;
/* 036 */
/* 037 */     inputadapter_input = inputs[0];
/* 038 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 039 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 040 */     agg_result = new UnsafeRow(1);
/* 041 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 042 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 043 */     locallimit_stopEarly = false;
/* 044 */     locallimit_count = 0;
/* 045 */     locallimit_result = new UnsafeRow(1);
/* 046 */     this.locallimit_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(locallimit_result, 0);
/* 047 */     this.locallimit_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(locallimit_holder, 1);
/* 048 */     globallimit_stopEarly = false;
/* 049 */     globallimit_count = 0;
/* 050 */     globallimit_result = new UnsafeRow(1);
/* 051 */     this.globallimit_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(globallimit_result, 0);
/* 052 */     this.globallimit_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(globallimit_holder, 1);
/* 053 */
/* 054 */   }
/* 055 */
/* 056 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 057 */     // initialize aggregation buffer
/* 058 */     final double agg_value = -1.0;
/* 059 */     agg_bufIsNull = true;
/* 060 */     agg_bufValue = agg_value;
/* 061 */
/* 062 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 063 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 064 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 065 */       double inputadapter_value = inputadapter_isNull ? -1.0 : (inputadapter_row.getDouble(0));
/* 066 */
/* 067 */       // do aggregate
/* 068 */       // common sub-expressions
/* 069 */
/* 070 */       // evaluate aggregate function
/* 071 */       boolean agg_isNull4 = true;
/* 072 */       double agg_value4 = -1.0;
/* 073 */
/* 074 */       boolean agg_isNull5 = agg_bufIsNull;
/* 075 */       double agg_value5 = agg_bufValue;
/* 076 */       if (agg_isNull5) {
/* 077 */         boolean agg_isNull7 = false;
/* 078 */         double agg_value7 = -1.0;
/* 079 */         if (!false) {
/* 080 */           agg_value7 = (double) 0;
/* 081 */         }
/* 082 */         if (!agg_isNull7) {
/* 083 */           agg_isNull5 = false;
/* 084 */           agg_value5 = agg_value7;
/* 085 */         }
/* 086 */       }
/* 087 */
/* 088 */       if (!inputadapter_isNull) {
/* 089 */         agg_isNull4 = false; // resultCode could change nullability.
/* 090 */         agg_value4 = agg_value5 + inputadapter_value;
/* 091 */
/* 092 */       }
/* 093 */       boolean agg_isNull3 = agg_isNull4;
/* 094 */       double agg_value3 = agg_value4;
/* 095 */       if (agg_isNull3) {
/* 096 */         if (!agg_bufIsNull) {
/* 097 */           agg_isNull3 = false;
/* 098 */           agg_value3 = agg_bufValue;
/* 099 */         }
/* 100 */       }
/* 101 */       // update aggregation buffer
/* 102 */       agg_bufIsNull = agg_isNull3;
/* 103 */       agg_bufValue = agg_value3;
/* 104 */       if (shouldStop()) return;
/* 105 */     }
/* 106 */
/* 107 */   }
/* 108 */
/* 109 */   @Override
/* 110 */   protected boolean stopEarly() {
/* 111 */     return globallimit_stopEarly;
/* 112 */   }
/* 113 */
/* 114 */   protected void processNext() throws java.io.IOException {
/* 115 */     while (!agg_initAgg) {
/* 116 */       agg_initAgg = true;
/* 117 */       long agg_beforeAgg = System.nanoTime();
/* 118 */       agg_doAggregateWithoutKey();
/* 119 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 120 */
/* 121 */       // output the result
/* 122 */
/* 123 */       agg_numOutputRows.add(1);
/* 124 */       if (locallimit_count < 100) {
/* 125 */         locallimit_count += 1;
/* 126 */
/* 127 */         if (globallimit_count < 100) {
/* 128 */           globallimit_count += 1;
/* 129 */
/* 130 */           globallimit_rowWriter.zeroOutNullBytes();
/* 131 */
/* 132 */           if (agg_bufIsNull) {
/* 133 */             globallimit_rowWriter.setNullAt(0);
/* 134 */           } else {
/* 135 */             globallimit_rowWriter.write(0, agg_bufValue);
/* 136 */           }
/* 137 */           append(globallimit_result);
/* 138 */
/* 139 */         } else {
/* 140 */           globallimit_stopEarly = true;
/* 141 */         }
/* 142 */
/* 143 */       } else {
/* 144 */         locallimit_stopEarly = true;
/* 145 */       }
/* 146 */     }
/* 147 */   }
/* 148 */ }
