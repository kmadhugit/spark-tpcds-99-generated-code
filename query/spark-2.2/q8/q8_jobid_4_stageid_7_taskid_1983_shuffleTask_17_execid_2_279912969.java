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
/* 040 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 041 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 042 */
/* 043 */     agg_result1 = new UnsafeRow(1);
/* 044 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
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
/* 057 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 058 */
/* 059 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 060 */
/* 061 */       UnsafeRow agg_fastAggBuffer = null;
/* 062 */
/* 063 */       if (agg_fastAggBuffer == null) {
/* 064 */         // generate grouping key
/* 065 */         agg_holder.reset();
/* 066 */
/* 067 */         agg_rowWriter.zeroOutNullBytes();
/* 068 */
/* 069 */         if (inputadapter_isNull) {
/* 070 */           agg_rowWriter.setNullAt(0);
/* 071 */         } else {
/* 072 */           agg_rowWriter.write(0, inputadapter_value);
/* 073 */         }
/* 074 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 075 */         agg_value2 = 42;
/* 076 */
/* 077 */         if (!inputadapter_isNull) {
/* 078 */           agg_value2 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value2);
/* 079 */         }
/* 080 */         if (true) {
/* 081 */           // try to get the buffer from hash map
/* 082 */           agg_unsafeRowAggBuffer =
/* 083 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value2);
/* 084 */         }
/* 085 */         if (agg_unsafeRowAggBuffer == null) {
/* 086 */           if (agg_sorter == null) {
/* 087 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 088 */           } else {
/* 089 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 090 */           }
/* 091 */
/* 092 */           // the hash map had be spilled, it should have enough memory now,
/* 093 */           // try  to allocate buffer again.
/* 094 */           agg_unsafeRowAggBuffer =
/* 095 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value2);
/* 096 */           if (agg_unsafeRowAggBuffer == null) {
/* 097 */             // failed to allocate the first page
/* 098 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 099 */           }
/* 100 */         }
/* 101 */       }
/* 102 */
/* 103 */       if (agg_fastAggBuffer != null) {
/* 104 */         // update fast row
/* 105 */
/* 106 */       } else {
/* 107 */         // update unsafe row
/* 108 */
/* 109 */         // common sub-expressions
/* 110 */
/* 111 */         // evaluate aggregate function
/* 112 */
/* 113 */         // update unsafe row buffer
/* 114 */
/* 115 */       }
/* 116 */       if (shouldStop()) return;
/* 117 */     }
/* 118 */
/* 119 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 120 */   }
/* 121 */
/* 122 */   protected void processNext() throws java.io.IOException {
/* 123 */     if (!agg_initAgg) {
/* 124 */       agg_initAgg = true;
/* 125 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 126 */       agg_doAggregateWithKeys();
/* 127 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 128 */     }
/* 129 */
/* 130 */     // output the result
/* 131 */
/* 132 */     while (agg_mapIter.next()) {
/* 133 */       wholestagecodegen_numOutputRows.add(1);
/* 134 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 135 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 136 */
/* 137 */       boolean agg_isNull4 = agg_aggKey.isNullAt(0);
/* 138 */       UTF8String agg_value4 = agg_isNull4 ? null : (agg_aggKey.getUTF8String(0));
/* 139 */       agg_holder1.reset();
/* 140 */
/* 141 */       agg_rowWriter1.zeroOutNullBytes();
/* 142 */
/* 143 */       if (agg_isNull4) {
/* 144 */         agg_rowWriter1.setNullAt(0);
/* 145 */       } else {
/* 146 */         agg_rowWriter1.write(0, agg_value4);
/* 147 */       }
/* 148 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 149 */       append(agg_result1);
/* 150 */
/* 151 */       if (shouldStop()) return;
/* 152 */     }
/* 153 */
/* 154 */     agg_mapIter.close();
/* 155 */     if (agg_sorter == null) {
/* 156 */       agg_hashMap.free();
/* 157 */     }
/* 158 */   }
/* 159 */ }
