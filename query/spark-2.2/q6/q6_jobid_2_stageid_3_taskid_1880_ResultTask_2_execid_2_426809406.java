/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 010 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 011 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 012 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 013 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 014 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 015 */   private scala.collection.Iterator inputadapter_input;
/* 016 */   private UnsafeRow agg_result;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 019 */   private int agg_value2;
/* 020 */   private UnsafeRow agg_result1;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 025 */
/* 026 */   public GeneratedIterator(Object[] references) {
/* 027 */     this.references = references;
/* 028 */   }
/* 029 */
/* 030 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 031 */     partitionIndex = index;
/* 032 */     this.inputs = inputs;
/* 033 */     agg_initAgg = false;
/* 034 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 035 */
/* 036 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 037 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 038 */     inputadapter_input = inputs[0];
/* 039 */     agg_result = new UnsafeRow(1);
/* 040 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 041 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 042 */
/* 043 */     agg_result1 = new UnsafeRow(1);
/* 044 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 045 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 1);
/* 046 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 047 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 048 */
/* 049 */   }
/* 050 */
/* 051 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 052 */     agg_hashMap = agg_plan.createHashMap();
/* 053 */
/* 054 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 055 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 056 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 057 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 058 */
/* 059 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 060 */
/* 061 */       UnsafeRow agg_fastAggBuffer = null;
/* 062 */
/* 063 */       if (agg_fastAggBuffer == null) {
/* 064 */         // generate grouping key
/* 065 */         agg_rowWriter.zeroOutNullBytes();
/* 066 */
/* 067 */         if (inputadapter_isNull) {
/* 068 */           agg_rowWriter.setNullAt(0);
/* 069 */         } else {
/* 070 */           agg_rowWriter.write(0, inputadapter_value);
/* 071 */         }
/* 072 */         agg_value2 = 42;
/* 073 */
/* 074 */         if (!inputadapter_isNull) {
/* 075 */           agg_value2 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value2);
/* 076 */         }
/* 077 */         if (true) {
/* 078 */           // try to get the buffer from hash map
/* 079 */           agg_unsafeRowAggBuffer =
/* 080 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value2);
/* 081 */         }
/* 082 */         if (agg_unsafeRowAggBuffer == null) {
/* 083 */           if (agg_sorter == null) {
/* 084 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 085 */           } else {
/* 086 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 087 */           }
/* 088 */
/* 089 */           // the hash map had be spilled, it should have enough memory now,
/* 090 */           // try  to allocate buffer again.
/* 091 */           agg_unsafeRowAggBuffer =
/* 092 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value2);
/* 093 */           if (agg_unsafeRowAggBuffer == null) {
/* 094 */             // failed to allocate the first page
/* 095 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 096 */           }
/* 097 */         }
/* 098 */       }
/* 099 */
/* 100 */       if (agg_fastAggBuffer != null) {
/* 101 */         // update fast row
/* 102 */
/* 103 */       } else {
/* 104 */         // update unsafe row
/* 105 */
/* 106 */         // common sub-expressions
/* 107 */
/* 108 */         // evaluate aggregate function
/* 109 */
/* 110 */         // update unsafe row buffer
/* 111 */
/* 112 */       }
/* 113 */       if (shouldStop()) return;
/* 114 */     }
/* 115 */
/* 116 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 117 */   }
/* 118 */
/* 119 */   protected void processNext() throws java.io.IOException {
/* 120 */     if (!agg_initAgg) {
/* 121 */       agg_initAgg = true;
/* 122 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 123 */       agg_doAggregateWithKeys();
/* 124 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 125 */     }
/* 126 */
/* 127 */     // output the result
/* 128 */
/* 129 */     while (agg_mapIter.next()) {
/* 130 */       wholestagecodegen_numOutputRows.add(1);
/* 131 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 132 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 133 */
/* 134 */       boolean agg_isNull4 = agg_aggKey.isNullAt(0);
/* 135 */       int agg_value4 = agg_isNull4 ? -1 : (agg_aggKey.getInt(0));
/* 136 */       agg_rowWriter1.zeroOutNullBytes();
/* 137 */
/* 138 */       if (agg_isNull4) {
/* 139 */         agg_rowWriter1.setNullAt(0);
/* 140 */       } else {
/* 141 */         agg_rowWriter1.write(0, agg_value4);
/* 142 */       }
/* 143 */       append(agg_result1);
/* 144 */
/* 145 */       if (shouldStop()) return;
/* 146 */     }
/* 147 */
/* 148 */     agg_mapIter.close();
/* 149 */     if (agg_sorter == null) {
/* 150 */       agg_hashMap.free();
/* 151 */     }
/* 152 */   }
/* 153 */ }
