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
/* 019 */   private int agg_value4;
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
/* 039 */     agg_result = new UnsafeRow(2);
/* 040 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 64);
/* 041 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 042 */
/* 043 */     agg_result1 = new UnsafeRow(2);
/* 044 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 045 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
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
/* 058 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 059 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 060 */
/* 061 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 062 */
/* 063 */       UnsafeRow agg_fastAggBuffer = null;
/* 064 */
/* 065 */       if (agg_fastAggBuffer == null) {
/* 066 */         // generate grouping key
/* 067 */         agg_holder.reset();
/* 068 */
/* 069 */         agg_rowWriter.zeroOutNullBytes();
/* 070 */
/* 071 */         if (inputadapter_isNull) {
/* 072 */           agg_rowWriter.setNullAt(0);
/* 073 */         } else {
/* 074 */           agg_rowWriter.write(0, inputadapter_value);
/* 075 */         }
/* 076 */
/* 077 */         if (inputadapter_isNull1) {
/* 078 */           agg_rowWriter.setNullAt(1);
/* 079 */         } else {
/* 080 */           agg_rowWriter.write(1, inputadapter_value1);
/* 081 */         }
/* 082 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 083 */         agg_value4 = 42;
/* 084 */
/* 085 */         if (!inputadapter_isNull) {
/* 086 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value4);
/* 087 */         }
/* 088 */
/* 089 */         if (!inputadapter_isNull1) {
/* 090 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value4);
/* 091 */         }
/* 092 */         if (true) {
/* 093 */           // try to get the buffer from hash map
/* 094 */           agg_unsafeRowAggBuffer =
/* 095 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 096 */         }
/* 097 */         if (agg_unsafeRowAggBuffer == null) {
/* 098 */           if (agg_sorter == null) {
/* 099 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 100 */           } else {
/* 101 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 102 */           }
/* 103 */
/* 104 */           // the hash map had be spilled, it should have enough memory now,
/* 105 */           // try  to allocate buffer again.
/* 106 */           agg_unsafeRowAggBuffer =
/* 107 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 108 */           if (agg_unsafeRowAggBuffer == null) {
/* 109 */             // failed to allocate the first page
/* 110 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 111 */           }
/* 112 */         }
/* 113 */       }
/* 114 */
/* 115 */       if (agg_fastAggBuffer != null) {
/* 116 */         // update fast row
/* 117 */
/* 118 */       } else {
/* 119 */         // update unsafe row
/* 120 */
/* 121 */         // common sub-expressions
/* 122 */
/* 123 */         // evaluate aggregate function
/* 124 */
/* 125 */         // update unsafe row buffer
/* 126 */
/* 127 */       }
/* 128 */       if (shouldStop()) return;
/* 129 */     }
/* 130 */
/* 131 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 132 */   }
/* 133 */
/* 134 */   protected void processNext() throws java.io.IOException {
/* 135 */     if (!agg_initAgg) {
/* 136 */       agg_initAgg = true;
/* 137 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 138 */       agg_doAggregateWithKeys();
/* 139 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 140 */     }
/* 141 */
/* 142 */     // output the result
/* 143 */
/* 144 */     while (agg_mapIter.next()) {
/* 145 */       wholestagecodegen_numOutputRows.add(1);
/* 146 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 147 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 148 */
/* 149 */       boolean agg_isNull7 = agg_aggKey.isNullAt(0);
/* 150 */       UTF8String agg_value7 = agg_isNull7 ? null : (agg_aggKey.getUTF8String(0));
/* 151 */       boolean agg_isNull8 = agg_aggKey.isNullAt(1);
/* 152 */       UTF8String agg_value8 = agg_isNull8 ? null : (agg_aggKey.getUTF8String(1));
/* 153 */       agg_holder1.reset();
/* 154 */
/* 155 */       agg_rowWriter1.zeroOutNullBytes();
/* 156 */
/* 157 */       if (agg_isNull7) {
/* 158 */         agg_rowWriter1.setNullAt(0);
/* 159 */       } else {
/* 160 */         agg_rowWriter1.write(0, agg_value7);
/* 161 */       }
/* 162 */
/* 163 */       if (agg_isNull8) {
/* 164 */         agg_rowWriter1.setNullAt(1);
/* 165 */       } else {
/* 166 */         agg_rowWriter1.write(1, agg_value8);
/* 167 */       }
/* 168 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 169 */       append(agg_result1);
/* 170 */
/* 171 */       if (shouldStop()) return;
/* 172 */     }
/* 173 */
/* 174 */     agg_mapIter.close();
/* 175 */     if (agg_sorter == null) {
/* 176 */       agg_hashMap.free();
/* 177 */     }
/* 178 */   }
/* 179 */ }
