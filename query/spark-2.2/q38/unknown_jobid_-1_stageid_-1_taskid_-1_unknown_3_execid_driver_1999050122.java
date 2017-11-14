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
/* 019 */   private int agg_value6;
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
/* 039 */     agg_result = new UnsafeRow(3);
/* 040 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 96);
/* 041 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 042 */
/* 043 */     agg_result1 = new UnsafeRow(3);
/* 044 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 96);
/* 045 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
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
/* 060 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 061 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 062 */
/* 063 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 064 */
/* 065 */       UnsafeRow agg_fastAggBuffer = null;
/* 066 */
/* 067 */       if (agg_fastAggBuffer == null) {
/* 068 */         // generate grouping key
/* 069 */         agg_holder.reset();
/* 070 */
/* 071 */         agg_rowWriter.zeroOutNullBytes();
/* 072 */
/* 073 */         if (inputadapter_isNull) {
/* 074 */           agg_rowWriter.setNullAt(0);
/* 075 */         } else {
/* 076 */           agg_rowWriter.write(0, inputadapter_value);
/* 077 */         }
/* 078 */
/* 079 */         if (inputadapter_isNull1) {
/* 080 */           agg_rowWriter.setNullAt(1);
/* 081 */         } else {
/* 082 */           agg_rowWriter.write(1, inputadapter_value1);
/* 083 */         }
/* 084 */
/* 085 */         if (inputadapter_isNull2) {
/* 086 */           agg_rowWriter.setNullAt(2);
/* 087 */         } else {
/* 088 */           agg_rowWriter.write(2, inputadapter_value2);
/* 089 */         }
/* 090 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 091 */         agg_value6 = 42;
/* 092 */
/* 093 */         if (!inputadapter_isNull) {
/* 094 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value6);
/* 095 */         }
/* 096 */
/* 097 */         if (!inputadapter_isNull1) {
/* 098 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value6);
/* 099 */         }
/* 100 */
/* 101 */         if (!inputadapter_isNull2) {
/* 102 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value6);
/* 103 */         }
/* 104 */         if (true) {
/* 105 */           // try to get the buffer from hash map
/* 106 */           agg_unsafeRowAggBuffer =
/* 107 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 108 */         }
/* 109 */         if (agg_unsafeRowAggBuffer == null) {
/* 110 */           if (agg_sorter == null) {
/* 111 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 112 */           } else {
/* 113 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 114 */           }
/* 115 */
/* 116 */           // the hash map had be spilled, it should have enough memory now,
/* 117 */           // try  to allocate buffer again.
/* 118 */           agg_unsafeRowAggBuffer =
/* 119 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 120 */           if (agg_unsafeRowAggBuffer == null) {
/* 121 */             // failed to allocate the first page
/* 122 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 123 */           }
/* 124 */         }
/* 125 */       }
/* 126 */
/* 127 */       if (agg_fastAggBuffer != null) {
/* 128 */         // update fast row
/* 129 */
/* 130 */       } else {
/* 131 */         // update unsafe row
/* 132 */
/* 133 */         // common sub-expressions
/* 134 */
/* 135 */         // evaluate aggregate function
/* 136 */
/* 137 */         // update unsafe row buffer
/* 138 */
/* 139 */       }
/* 140 */       if (shouldStop()) return;
/* 141 */     }
/* 142 */
/* 143 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 144 */   }
/* 145 */
/* 146 */   protected void processNext() throws java.io.IOException {
/* 147 */     if (!agg_initAgg) {
/* 148 */       agg_initAgg = true;
/* 149 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 150 */       agg_doAggregateWithKeys();
/* 151 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 152 */     }
/* 153 */
/* 154 */     // output the result
/* 155 */
/* 156 */     while (agg_mapIter.next()) {
/* 157 */       wholestagecodegen_numOutputRows.add(1);
/* 158 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 159 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 160 */
/* 161 */       boolean agg_isNull10 = agg_aggKey.isNullAt(0);
/* 162 */       UTF8String agg_value10 = agg_isNull10 ? null : (agg_aggKey.getUTF8String(0));
/* 163 */       boolean agg_isNull11 = agg_aggKey.isNullAt(1);
/* 164 */       UTF8String agg_value11 = agg_isNull11 ? null : (agg_aggKey.getUTF8String(1));
/* 165 */       boolean agg_isNull12 = agg_aggKey.isNullAt(2);
/* 166 */       UTF8String agg_value12 = agg_isNull12 ? null : (agg_aggKey.getUTF8String(2));
/* 167 */       agg_holder1.reset();
/* 168 */
/* 169 */       agg_rowWriter1.zeroOutNullBytes();
/* 170 */
/* 171 */       if (agg_isNull10) {
/* 172 */         agg_rowWriter1.setNullAt(0);
/* 173 */       } else {
/* 174 */         agg_rowWriter1.write(0, agg_value10);
/* 175 */       }
/* 176 */
/* 177 */       if (agg_isNull11) {
/* 178 */         agg_rowWriter1.setNullAt(1);
/* 179 */       } else {
/* 180 */         agg_rowWriter1.write(1, agg_value11);
/* 181 */       }
/* 182 */
/* 183 */       if (agg_isNull12) {
/* 184 */         agg_rowWriter1.setNullAt(2);
/* 185 */       } else {
/* 186 */         agg_rowWriter1.write(2, agg_value12);
/* 187 */       }
/* 188 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 189 */       append(agg_result1);
/* 190 */
/* 191 */       if (shouldStop()) return;
/* 192 */     }
/* 193 */
/* 194 */     agg_mapIter.close();
/* 195 */     if (agg_sorter == null) {
/* 196 */       agg_hashMap.free();
/* 197 */     }
/* 198 */   }
/* 199 */ }
